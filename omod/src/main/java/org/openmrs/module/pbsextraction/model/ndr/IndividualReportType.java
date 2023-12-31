//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:46:26 AM WAT
//

package org.openmrs.module.pbsextraction.model.ndr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for IndividualReportType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientDemographics" type="{}PatientDemographicsType"/>
 *         &lt;element name="Condition" type="{}ConditionType" maxOccurs="unbounded"/>
 *         &lt;element name="HIVTestingReport" type="{}HIVTestingReportType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "IndividualReportType", propOrder = { "patientDemographics", "condition", "hivTestingReport", "pmtctType" })
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "IndividualReportType", propOrder = { "patientDemographics", "condition", "hivTestingReport", "pmtct", "tb",
        "mortality", "recency" })
public class IndividualReportType {
	
	@XmlElement(name = "PatientDemographics", required = true)
	protected PatientDemographicsType patientDemographics;
	
	@XmlElement(name = "Condition", required = true)
	protected List<ConditionType> condition;
	
	@XmlElement(name = "HIVTestingReport")
	protected List<HIVTestingReportType> hivTestingReport;
	
	@XmlElement(name = "PMTCT")
	protected PMTCTType pmtct;
	
	@XmlElement(name = "TB")
	protected TBType tb;
	
	@XmlElement(name = "Mortality")
	protected List<MortalityType> mortality;
	
	@XmlElement(name = "Recency")
	protected List<RecencyType> recency;
	
	/**
	 * Gets the value of the patientDemographics property.
	 * 
	 * @return possible object is {@link PatientDemographicsType }
	 */
	public PatientDemographicsType getPatientDemographics() {
		return patientDemographics;
	}
	
	/**
	 * Sets the value of the patientDemographics property.
	 * 
	 * @param value allowed object is {@link PatientDemographicsType }
	 */
	public void setPatientDemographics(PatientDemographicsType value) {
		this.patientDemographics = value;
	}
	
	/**
	 * Gets the value of the condition property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the condition property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 *    getCondition().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link ConditionType }
	 */
	public List<ConditionType> getCondition() {
		if (condition == null) {
			condition = new ArrayList<ConditionType>();
		}
		return this.condition;
	}
	
	/**
	 * Gets the value of the hivTestingReport property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the hivTestingReport property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 *    getHIVTestingReport().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link HIVTestingReportType }
	 */
	public List<HIVTestingReportType> getHIVTestingReport() {
		if (hivTestingReport == null) {
			hivTestingReport = new ArrayList<HIVTestingReportType>();
		}
		return this.hivTestingReport;
	}
	
	public PMTCTType getPmtctType() {
		return pmtct;
	}
	
	public void setPmtctType(PMTCTType pmtct) {
		this.pmtct = pmtct;
	}
	
	/**
	 * Gets the value of the tb property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the tb property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 *    getTB().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TBType }
	 */
	public TBType getTB() {
		return tb;
	}
	
	public void setTB(TBType tb) {
		this.tb = tb;
	}
	
	public List<RecencyType> getRecency() {
		if (recency == null) {
			recency = new ArrayList<RecencyType>();
		}
		return this.recency;
	}
	
	public List<MortalityType> getMortality() {
		if (mortality == null) {
			mortality = new ArrayList<MortalityType>();
		}
		return this.mortality;
	}
	
}
