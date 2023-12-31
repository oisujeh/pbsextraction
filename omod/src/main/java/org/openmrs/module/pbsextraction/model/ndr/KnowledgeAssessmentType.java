//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:46:26 AM WAT 
//
package org.openmrs.module.pbsextraction.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for KnowledgeAssessmentType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KnowledgeAssessmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PreviouslyTestedHIVNegative" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ClientInformedAboutHIVTransmissionRoutes" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ClientPregnant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ClientInformedOfHIVTransmissionRiskFactors" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ClientInformedAboutPreventingHIV" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ClientInformedAboutPossibleTestResults" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="InformedConsentForHIVTestingGiven" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KnowledgeAssessmentType", propOrder = { "previouslyTestedHIVNegative",
        "clientInformedAboutHIVTransmissionRoutes", "clientPregnant", "clientInformedOfHIVTransmissionRiskFactors",
        "clientInformedAboutPreventingHIV", "clientInformedAboutPossibleTestResults", "informedConsentForHIVTestingGiven" })
public class KnowledgeAssessmentType {
	
	@XmlElement(name = "PreviouslyTestedHIVNegative")
	protected Boolean previouslyTestedHIVNegative;
	
	@XmlElement(name = "ClientInformedAboutHIVTransmissionRoutes")
	protected Boolean clientInformedAboutHIVTransmissionRoutes;
	
	@XmlElement(name = "ClientPregnant")
	protected Boolean clientPregnant;
	
	@XmlElement(name = "ClientInformedOfHIVTransmissionRiskFactors")
	protected Boolean clientInformedOfHIVTransmissionRiskFactors;
	
	@XmlElement(name = "ClientInformedAboutPreventingHIV")
	protected Boolean clientInformedAboutPreventingHIV;
	
	@XmlElement(name = "ClientInformedAboutPossibleTestResults")
	protected Boolean clientInformedAboutPossibleTestResults;
	
	@XmlElement(name = "InformedConsentForHIVTestingGiven")
	protected Boolean informedConsentForHIVTestingGiven;
	
	/**
	 * Gets the value of the previouslyTestedHIVNegative property.
	 */
	public boolean isPreviouslyTestedHIVNegative() {
		return previouslyTestedHIVNegative;
	}
	
	/**
	 * Sets the value of the previouslyTestedHIVNegative property.
	 */
	public void setPreviouslyTestedHIVNegative(boolean value) {
		this.previouslyTestedHIVNegative = value;
	}
	
	/**
	 * Gets the value of the clientInformedAboutHIVTransmissionRoutes property.
	 */
	public boolean isClientInformedAboutHIVTransmissionRoutes() {
		return clientInformedAboutHIVTransmissionRoutes;
	}
	
	/**
	 * Sets the value of the clientInformedAboutHIVTransmissionRoutes property.
	 */
	public void setClientInformedAboutHIVTransmissionRoutes(boolean value) {
		this.clientInformedAboutHIVTransmissionRoutes = value;
	}
	
	/**
	 * Gets the value of the clientPregnant property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isClientPregnant() {
		return clientPregnant;
	}
	
	/**
	 * Sets the value of the clientPregnant property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setClientPregnant(Boolean value) {
		this.clientPregnant = value;
	}
	
	/**
	 * Gets the value of the clientInformedOfHIVTransmissionRiskFactors property.
	 */
	public boolean isClientInformedOfHIVTransmissionRiskFactors() {
		return clientInformedOfHIVTransmissionRiskFactors;
	}
	
	/**
	 * Sets the value of the clientInformedOfHIVTransmissionRiskFactors property.
	 */
	public void setClientInformedOfHIVTransmissionRiskFactors(boolean value) {
		this.clientInformedOfHIVTransmissionRiskFactors = value;
	}
	
	/**
	 * Gets the value of the clientInformedAboutPreventingHIV property.
	 */
	public boolean isClientInformedAboutPreventingHIV() {
		return clientInformedAboutPreventingHIV;
	}
	
	/**
	 * Sets the value of the clientInformedAboutPreventingHIV property.
	 */
	public void setClientInformedAboutPreventingHIV(boolean value) {
		this.clientInformedAboutPreventingHIV = value;
	}
	
	/**
	 * Gets the value of the clientInformedAboutPossibleTestResults property.
	 */
	public boolean isClientInformedAboutPossibleTestResults() {
		return clientInformedAboutPossibleTestResults;
	}
	
	/**
	 * Sets the value of the clientInformedAboutPossibleTestResults property.
	 */
	public void setClientInformedAboutPossibleTestResults(boolean value) {
		this.clientInformedAboutPossibleTestResults = value;
	}
	
	/**
	 * Gets the value of the informedConsentForHIVTestingGiven property.
	 */
	public boolean isInformedConsentForHIVTestingGiven() {
		return informedConsentForHIVTestingGiven;
	}
	
	/**
	 * Sets the value of the informedConsentForHIVTestingGiven property.
	 */
	public void setInformedConsentForHIVTestingGiven(boolean value) {
		this.informedConsentForHIVTestingGiven = value;
	}
	
	public boolean isEmpty() {
		if (this.previouslyTestedHIVNegative == null && this.clientInformedAboutHIVTransmissionRoutes == null
		        && this.clientPregnant == null && this.clientInformedOfHIVTransmissionRiskFactors == null
		        && this.clientInformedAboutPreventingHIV == null && this.clientInformedAboutPossibleTestResults == null
		        && this.informedConsentForHIVTestingGiven == null) {
			return true;
		} else {
			return false;
		}
	}
	
}
