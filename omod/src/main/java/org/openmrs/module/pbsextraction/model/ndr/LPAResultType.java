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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for LPAResultType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LPAResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NameOfAminoglycoside" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameOfAminoglycosideResistantPattern" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Resistant"/>
 *               &lt;enumeration value="Susceptible"/>
 *               &lt;enumeration value="Indeterminate"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NameOofQuinolone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameOofQuinoloneResistantPattern" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Resistant"/>
 *               &lt;enumeration value="Susceptible"/>
 *               &lt;enumeration value="Indeterminate"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LPAResultType", propOrder = { "nameOfAminoglycoside", "nameOfAminoglycosideResistantPattern",
        "nameOofQuinolone", "nameOofQuinoloneResistantPattern" })
public class LPAResultType {
	
	@XmlElement(name = "NameOfAminoglycoside")
	protected String nameOfAminoglycoside;
	
	@XmlElement(name = "NameOfAminoglycosideResistantPattern")
	protected String nameOfAminoglycosideResistantPattern;
	
	@XmlElement(name = "NameOofQuinolone")
	protected String nameOofQuinolone;
	
	@XmlElement(name = "NameOofQuinoloneResistantPattern")
	protected String nameOofQuinoloneResistantPattern;
	
	/**
	 * Gets the value of the nameOfAminoglycoside property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNameOfAminoglycoside() {
		return nameOfAminoglycoside;
	}
	
	/**
	 * Sets the value of the nameOfAminoglycoside property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNameOfAminoglycoside(String value) {
		this.nameOfAminoglycoside = value;
	}
	
	/**
	 * Gets the value of the nameOfAminoglycosideResistantPattern property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNameOfAminoglycosideResistantPattern() {
		return nameOfAminoglycosideResistantPattern;
	}
	
	/**
	 * Sets the value of the nameOfAminoglycosideResistantPattern property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNameOfAminoglycosideResistantPattern(String value) {
		this.nameOfAminoglycosideResistantPattern = value;
	}
	
	/**
	 * Gets the value of the nameOofQuinolone property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNameOofQuinolone() {
		return nameOofQuinolone;
	}
	
	/**
	 * Sets the value of the nameOofQuinolone property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNameOofQuinolone(String value) {
		this.nameOofQuinolone = value;
	}
	
	/**
	 * Gets the value of the nameOofQuinoloneResistantPattern property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNameOofQuinoloneResistantPattern() {
		return nameOofQuinoloneResistantPattern;
	}
	
	/**
	 * Sets the value of the nameOofQuinoloneResistantPattern property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNameOofQuinoloneResistantPattern(String value) {
		this.nameOofQuinoloneResistantPattern = value;
	}
	
}