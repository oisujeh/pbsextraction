//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2022.11.01 at 09:42:41 AM WAT
//

package org.openmrs.module.pbsextraction.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for TBPatientReferralType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TBPatientReferralType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="TBReasonForReferral" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="DSTB"/>
 *               &lt;enumeration value="DRTB"/>
 *               &lt;enumeration value="TransferToOtherCenter"/>
 *               &lt;enumeration value="ReferringPerson"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FacilityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LGA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferringFacilityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferringFacilityLGA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferringFacilityState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityReferredTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferredFacilityLGA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferredFacilityState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TypeOfTBPatient" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="New"/>
 *               &lt;enumeration value="Relapse"/>
 *               &lt;enumeration value="TBTreatmentAfterFailure"/>
 *               &lt;enumeration value="TreatmentAfterLossToFollowup"/>
 *               &lt;enumeration value="OtherPreviouslyTreated"/>
 *               &lt;enumeration value="PatientsWithUnknownPreviousTBTreatmentHistory"/>
 *               &lt;enumeration value="TransferIn"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FormCompleted" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="DR-TB"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherReferrals" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specimenID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmearResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MycobacteriumuTBDetectedWithRifampinResistance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CultureResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OtherTBTestResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TBPatientReferralType", propOrder = { "visitID", "visitDate", "tbReasonForReferral", "facilityCode", "lga",
        "referringFacilityName", "referringFacilityLGA", "referringFacilityState", "facilityReferredTo",
        "referredFacilityLGA", "referredFacilityState", "typeOfTBPatient", "formCompleted", "otherReferrals", "specimenID",
        "smearResult", "mycobacteriumuTBDetectedWithRifampinResistance", "cultureResult", "otherTBTestResult" })
public class TBPatientReferralType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "TBReasonForReferral")
	protected String tbReasonForReferral;
	
	@XmlElement(name = "FacilityCode")
	protected String facilityCode;
	
	@XmlElement(name = "LGA")
	protected String lga;
	
	@XmlElement(name = "ReferringFacilityName", required = true)
	protected String referringFacilityName;
	
	@XmlElement(name = "ReferringFacilityLGA", required = true)
	protected String referringFacilityLGA;
	
	@XmlElement(name = "ReferringFacilityState", required = true)
	protected String referringFacilityState;
	
	@XmlElement(name = "FacilityReferredTo", required = true)
	protected String facilityReferredTo;
	
	@XmlElement(name = "ReferredFacilityLGA", required = true)
	protected String referredFacilityLGA;
	
	@XmlElement(name = "ReferredFacilityState", required = true)
	protected String referredFacilityState;
	
	@XmlElement(name = "TypeOfTBPatient")
	protected String typeOfTBPatient;
	
	@XmlElement(name = "FormCompleted")
	protected String formCompleted;
	
	@XmlElement(name = "OtherReferrals")
	protected String otherReferrals;
	
	protected String specimenID;
	
	@XmlElement(name = "SmearResult")
	protected String smearResult;
	
	@XmlElement(name = "MycobacteriumuTBDetectedWithRifampinResistance")
	protected String mycobacteriumuTBDetectedWithRifampinResistance;
	
	@XmlElement(name = "CultureResult")
	protected String cultureResult;
	
	@XmlElement(name = "OtherTBTestResult")
	protected String otherTBTestResult;
	
	/**
	 * Gets the value of the visitID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisitID() {
		return visitID;
	}
	
	/**
	 * Sets the value of the visitID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisitID(String value) {
		this.visitID = value;
	}
	
	/**
	 * Gets the value of the visitDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getVisitDate() {
		return visitDate;
	}
	
	/**
	 * Sets the value of the visitDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setVisitDate(XMLGregorianCalendar value) {
		this.visitDate = value;
	}
	
	/**
	 * Gets the value of the tbReasonForReferral property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTBReasonForReferral() {
		return tbReasonForReferral;
	}
	
	/**
	 * Sets the value of the tbReasonForReferral property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTBReasonForReferral(String value) {
		this.tbReasonForReferral = value;
	}
	
	/**
	 * Gets the value of the facilityCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFacilityCode() {
		return facilityCode;
	}
	
	/**
	 * Sets the value of the facilityCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFacilityCode(String value) {
		this.facilityCode = value;
	}
	
	/**
	 * Gets the value of the lga property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLGA() {
		return lga;
	}
	
	/**
	 * Sets the value of the lga property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLGA(String value) {
		this.lga = value;
	}
	
	/**
	 * Gets the value of the referringFacilityName property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferringFacilityName() {
		return referringFacilityName;
	}
	
	/**
	 * Sets the value of the referringFacilityName property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferringFacilityName(String value) {
		this.referringFacilityName = value;
	}
	
	/**
	 * Gets the value of the referringFacilityLGA property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferringFacilityLGA() {
		return referringFacilityLGA;
	}
	
	/**
	 * Sets the value of the referringFacilityLGA property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferringFacilityLGA(String value) {
		this.referringFacilityLGA = value;
	}
	
	/**
	 * Gets the value of the referringFacilityState property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferringFacilityState() {
		return referringFacilityState;
	}
	
	/**
	 * Sets the value of the referringFacilityState property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferringFacilityState(String value) {
		this.referringFacilityState = value;
	}
	
	/**
	 * Gets the value of the facilityReferredTo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFacilityReferredTo() {
		return facilityReferredTo;
	}
	
	/**
	 * Sets the value of the facilityReferredTo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFacilityReferredTo(String value) {
		this.facilityReferredTo = value;
	}
	
	/**
	 * Gets the value of the referredFacilityLGA property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferredFacilityLGA() {
		return referredFacilityLGA;
	}
	
	/**
	 * Sets the value of the referredFacilityLGA property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferredFacilityLGA(String value) {
		this.referredFacilityLGA = value;
	}
	
	/**
	 * Gets the value of the referredFacilityState property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferredFacilityState() {
		return referredFacilityState;
	}
	
	/**
	 * Sets the value of the referredFacilityState property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferredFacilityState(String value) {
		this.referredFacilityState = value;
	}
	
	/**
	 * Gets the value of the typeOfTBPatient property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTypeOfTBPatient() {
		return typeOfTBPatient;
	}
	
	/**
	 * Sets the value of the typeOfTBPatient property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTypeOfTBPatient(String value) {
		this.typeOfTBPatient = value;
	}
	
	/**
	 * Gets the value of the formCompleted property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFormCompleted() {
		return formCompleted;
	}
	
	/**
	 * Sets the value of the formCompleted property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFormCompleted(String value) {
		this.formCompleted = value;
	}
	
	/**
	 * Gets the value of the otherReferrals property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherReferrals() {
		return otherReferrals;
	}
	
	/**
	 * Sets the value of the otherReferrals property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherReferrals(String value) {
		this.otherReferrals = value;
	}
	
	/**
	 * Gets the value of the specimenID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSpecimenID() {
		return specimenID;
	}
	
	/**
	 * Sets the value of the specimenID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSpecimenID(String value) {
		this.specimenID = value;
	}
	
	/**
	 * Gets the value of the smearResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSmearResult() {
		return smearResult;
	}
	
	/**
	 * Sets the value of the smearResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSmearResult(String value) {
		this.smearResult = value;
	}
	
	/**
	 * Gets the value of the mycobacteriumuTBDetectedWithRifampinResistance property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMycobacteriumuTBDetectedWithRifampinResistance() {
		return mycobacteriumuTBDetectedWithRifampinResistance;
	}
	
	/**
	 * Sets the value of the mycobacteriumuTBDetectedWithRifampinResistance property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMycobacteriumuTBDetectedWithRifampinResistance(String value) {
		this.mycobacteriumuTBDetectedWithRifampinResistance = value;
	}
	
	/**
	 * Gets the value of the cultureResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCultureResult() {
		return cultureResult;
	}
	
	/**
	 * Sets the value of the cultureResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCultureResult(String value) {
		this.cultureResult = value;
	}
	
	/**
	 * Gets the value of the otherTBTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherTBTestResult() {
		return otherTBTestResult;
	}
	
	/**
	 * Sets the value of the otherTBTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherTBTestResult(String value) {
		this.otherTBTestResult = value;
	}
	
}
