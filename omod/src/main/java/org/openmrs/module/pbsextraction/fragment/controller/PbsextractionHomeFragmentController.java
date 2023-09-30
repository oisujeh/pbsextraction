package org.openmrs.module.pbsextraction.fragment.controller;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.PersonAddress;
import org.openmrs.module.pbsextraction.Utils.Utils;
import org.openmrs.module.pbsextraction.db.NdrDBManager;
import org.openmrs.module.pbsextraction.model.DBConnection;
import org.openmrs.module.pbsextraction.model.ndr.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PbsextractionHomeFragmentController {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	SimpleDateFormat visitID = new SimpleDateFormat("yyyyMMdd");
	
	private static final Log LOG = LogFactory.getLog(PbsextractionHomeFragmentController.class);
	
	Container containerTemplate = null;

	private Patient patient;
	
	String reportType = "FingerPrintVerification";
	
	Gson gson = new Gson();

	private final DBConnection openmrsConn;

	private PreparedStatement pStatement1;
	
	NdrDBManager nd = new NdrDBManager();
	
	private ResultSet result;
	
	private List<Integer> list;
	
	List<String> filesListInDir = new ArrayList<String>();
	
	private String reportFolder;
	
	private String formattedDate;

	public PbsextractionHomeFragmentController(Patient patient, DBConnection openmrsConn, PreparedStatement pStatement1) {
		this.patient = patient;
		this.openmrsConn = openmrsConn;
		this.pStatement1 = pStatement1;
	}

	public String extractFingerprint(@RequestParam(value = "startdate", required = true) String startdate,
	        @RequestParam(value = "enddate", required = true) String enddate, HttpServletRequest request) {
		List<String> outputList = new ArrayList<>();
		try {

			list = new ArrayList<>();
			Utils.ensureReportFolderExistDelete(request, reportType);
			nd.openConnection();
			list = nd.getPatientBiometricsVerifyDistinctList(startdate, enddate);
			getPatientBiometricsVerifyContainer(startdate, enddate, request);

			String datimCode = Utils.getFacilityLocalId();
			String facilityName = Utils.getFacilityName();
			String IPShortName = Utils.getIPShortName();


			String zipFileName = IPShortName + "_" + "Fingerprintverification" + "_" + datimCode + "_" + formattedDate + ".zip";

			String filepath = Utils.zipFolder(request, reportFolder, zipFileName, reportType);


			outputList.add(zipFileName);
			outputList.add(formattedDate);
			outputList.add(String.valueOf(list.size()));
			outputList.add(filepath);

		}catch (Exception e) {

			Logger.getLogger(PbsextractionHomeFragmentController.class.getName()).log(Level.SEVERE, null, e);

		}finally {
			try{
				nd.closeConnection();
			}catch (Exception e){

			}
		}
		return gson.toJson(outputList);
	}
	
	public void getPatientBiometricsVerifyContainer(String startdate, String enddate, HttpServletRequest request)
	        throws Exception {
		String patientIdentifier = "";
		for (int i = 0; i < list.size(); i++) {
			System.out.println("getPatientBiometricsVerifyContainer " + String.valueOf(list.get(i)));
			result = nd.getPatientBiometricsVerify(startdate, enddate, Integer.parseInt(String.valueOf(list.get(i))));
			containerTemplate = new Container();
			FingerPrintType fingerPrintsType = new FingerPrintType();
			RightHandType rightFingerType = new RightHandType();
			LeftHandType leftFingerType = new LeftHandType();
			XMLGregorianCalendar dataCaptured = null;
			
			NdrDBManager nd = new NdrDBManager();
			Utils u = new Utils();
			
			Date date = new Date();
			MessageHeaderType messageHeaderType = new MessageHeaderType();
			messageHeaderType.setMessageStatusCode("UPDATED");
			messageHeaderType.setMessageCreationDateTime(u.getXmlDateTime(new Date()));
			messageHeaderType.setMessageSchemaVersion(String.valueOf(1.6));
			messageHeaderType.setMessageUniqueID(UUID.randomUUID().toString());

			FacilityType messageSendingOrganisationType = new FacilityType();
			messageSendingOrganisationType.setFacilityID(u.getFacilityDATIMId());
			messageSendingOrganisationType.setFacilityName(u.getFacilityName());
			messageSendingOrganisationType.setFacilityTypeCode(u.getFacilityType());
			
			messageHeaderType.setMessageSendingOrganization(messageSendingOrganisationType);
			containerTemplate.setMessageHeader(messageHeaderType);
			
			while (result.next()) {


				System.out.println("patient ids " + result.getInt("patient_Id"));
				// ResultSet result = nd.getPatientBiometricsVerify(startdate, enddate);
				String fingerposition = result.getString("fingerPosition");
				
				try {
					dataCaptured = u.getXmlDateTime(result.getDate("date_created"));
				}
				catch (Exception e) {
					
				}
				

				patientIdentifier = result.getString("identifier"); //patient.getPatientIdentifier(4).getIdentifier();
				
				if ("RightThumb".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					rightFingerType.setRightThumb(templateValue);
					rightFingerType.setRightThumbQuality(result.getInt("imageQuality"));
				} else if ("RightIndex".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					rightFingerType.setRightIndex(templateValue);
					rightFingerType.setRightIndexQuality(result.getInt("imageQuality"));
				} else if ("RightMiddle".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					rightFingerType.setRightMiddle(templateValue);
					rightFingerType.setRightMiddleQuality(result.getInt("imageQuality"));
				} else if ("RightWedding".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					rightFingerType.setRightWedding(templateValue);
					rightFingerType.setRightWeddingQuality(result.getInt("imageQuality"));
				} else if ("RightSmall".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					rightFingerType.setRightSmall(templateValue);
					rightFingerType.setRightSmallQuality(result.getInt("imageQuality"));
				} else if ("LeftThumb".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					leftFingerType.setLeftThumb(templateValue);
					leftFingerType.setLeftThumbQuality(result.getInt("imageQuality"));
				} else if ("LeftIndex".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					leftFingerType.setLeftIndex(templateValue);
					leftFingerType.setLeftIndexQuality(result.getInt("imageQuality"));
				} else if ("LeftMiddle".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					leftFingerType.setLeftMiddle(templateValue);
					leftFingerType.setLeftMiddleQuality(result.getInt("imageQuality"));
				} else if ("LeftWedding".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					leftFingerType.setLeftWedding(templateValue);
					leftFingerType.setLeftWeddingQuality(result.getInt("imageQuality"));
				} else if ("LeftSmall".equals(fingerposition)) {
					String templateValue = result.getString("template");
					if (templateValue == null || templateValue.isEmpty()) {
						templateValue = result.getString("new_template");
					}
					leftFingerType.setLeftSmall(templateValue);
					leftFingerType.setLeftSmallQuality(result.getInt("imageQuality"));
				}

				IndividualReportType individualReportType = new IndividualReportType();

				
				PatientDemographicsType patientDemographicsType = new PatientDemographicsType();
				individualReportType.setPatientDemographics(patientDemographicsType);
				patientDemographicsType.setPatientIdentifier(patientIdentifier);
				patientDemographicsType.setTreatmentFacility(messageSendingOrganisationType);
				fingerPrintsType.setDateCaptured(dataCaptured);
				fingerPrintsType.setRightHand(rightFingerType);
				fingerPrintsType.setLeftHand(leftFingerType);
				patientDemographicsType.setFingerPrints(fingerPrintsType);


				ConditionType condition = createHIVCondition();
				individualReportType.getCondition().add(condition);

				containerTemplate.setIndividualReport(individualReportType);
				
			}
			
			exportXML(patientIdentifier, request);
			
		}
		
	}

	private ConditionType createHIVCondition() {

		ConditionType condition = new ConditionType();

		try {
			condition.setConditionCode("86406008");
			//create address
			condition.setPatientAddress(createPatientAddress());
			//create program area
			condition.setProgramArea(createProgramArea());
			if(!patient.isVoided()) {
				return condition;
			}
		} catch (Exception ex) {

		}
		return condition;
	}

	private ProgramAreaType createProgramArea() {
		ProgramAreaType p = new ProgramAreaType();
		p.setProgramAreaCode("HIV");
		return p;
	}

	private AddressType createPatientAddress() {
		AddressType p = new AddressType();
		p.setAddressTypeCode("H");
		p.setCountryCode("NGA");
		Connection connection = null;
		Statement statement = null;

		PersonAddress pa = patient.getPersonAddress();
		if (pa != null) {
			//p.setTown(pa.getAddress1());
			String lga = pa.getCityVillage();
			String state = pa.getStateProvince();

			try {
				String sql = String
						.format(
								"SELECT `name`, user_generated_id, 'STATE' AS 'Location' "
										+ "FROM address_hierarchy_entry WHERE level_id =2 AND NAME = '%s' "
										+ "UNION "
										+ "SELECT `name`, user_generated_id, 'LGA' AS 'Location' FROM address_hierarchy_entry "
										+ " WHERE level_id =3 AND NAME ='%s' AND parent_id = (SELECT address_hierarchy_entry_id FROM address_hierarchy_entry\n"
										+ " WHERE level_id =2 AND NAME = '%s')", state, lga, state);

				connection = DriverManager.getConnection(this.openmrsConn.getUrl(), this.openmrsConn.getUsername(),
						this.openmrsConn.getPassword());
				statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					//String name = result.getString("name");
					if (result.getString("Location").contains("STATE")) {
						p.setStateCode(result.getString("user_generated_id"));
					} else {
						p.setLGACode(result.getString("user_generated_id"));
					}
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {

				try {
					if (connection != null) {
						connection.close();
					}

					if (statement != null) {
						statement.close();
					}

				}
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}

		}
		return p;
	}
	
	private void writeFile(Container ndrReportTemplate, File file, Marshaller jaxbMarshaller) {
		
		try {
			//	javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
			jaxbMarshaller.marshal(ndrReportTemplate, file);
			
		}
		catch (Exception ex) {
			System.out.println("File " + file.getName() + " throw an exception \n" + ex.getMessage());
			//	throw ex;
		}
		
	}
	
	public void exportXML(String PatientIdentifier, HttpServletRequest request) throws Exception {
		
		JAXBContext jaxbContext;
		String datimCode = Utils.getFacilityLocalId();
		String IPShortName = Utils.getIPShortName();
		System.out.println("about to create jaxb context");
		// jaxbContext = JAXBContext.newInstance("org.openmrs.module.openhmis.ndrmodel");
		jaxbContext = JAXBContext.newInstance(Container.class);
		System.out.println("done creating jaxb context");
		System.out.println("about to create marshaller");
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		System.out.println("done creating marshaller");
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		formattedDate = new SimpleDateFormat("ddMMyy").format(new Date());
		
		if (containerTemplate != null) {
			
			System.out.println("starting xml creating process");
			LOG.info("Testing log4j");
			reportFolder = Utils.ensureReportFolderExist(request, reportType);
			datimCode = datimCode.replace("/", "_");
			
			String fileName = IPShortName + "_" + "Fingerprintverification" + "_" + datimCode + "_" + PatientIdentifier
			        + "_" + formattedDate;
			System.out.println("File name is " + fileName);
			
			String xmlFile = Paths.get(reportFolder, fileName + ".xml").toString();
			
			File aXMLFile = new File(xmlFile);
			
			Boolean b;
			
			b = aXMLFile.createNewFile();
			//System.out.println("creating xml file : " + xmlFile + "was successful : " + b);
			writeFile(containerTemplate, aXMLFile, jaxbMarshaller);
			
		}
	}
	
	private void zipDirectory(File dir, String zipDirName) {
		try {
			populateFilesList(dir);
			//now zip files one by one
			//create ZipOutputStream to write to the zip file
			FileOutputStream fos = new FileOutputStream(zipDirName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for (String filePath : filesListInDir) {
				System.out.println("Zipping " + filePath);
				//for ZipEntry we need to keep only relative file path, so we used substring on absolute path
				ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
				zos.putNextEntry(ze);
				//read the file and write to ZipOutputStream
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
			fos.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method populates all the files in a directory to a List
	 * 
	 * @param dir
	 * @throws IOException
	 */
	private void populateFilesList(File dir) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isFile())
				filesListInDir.add(file.getAbsolutePath());
			else
				populateFilesList(file);
		}
	}
	
	boolean deleteDirectory(File directoryToBeDeleted) {
		File[] allContents = directoryToBeDeleted.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				deleteDirectory(file);
			}
		}
		return directoryToBeDeleted.delete();
	}
	
}
