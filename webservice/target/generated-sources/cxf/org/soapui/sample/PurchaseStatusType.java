
package org.soapui.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PurchaseStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PurchaseStatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="stockStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="expectedDelivery" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseStatusType", propOrder = {
    "id",
    "stockStatus",
    "expectedDelivery"
})
public class PurchaseStatusType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String stockStatus;
    @XmlElement(required = true)
    protected String expectedDelivery;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the stockStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockStatus() {
        return stockStatus;
    }

    /**
     * Sets the value of the stockStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockStatus(String value) {
        this.stockStatus = value;
    }

    /**
     * Gets the value of the expectedDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedDelivery() {
        return expectedDelivery;
    }

    /**
     * Sets the value of the expectedDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedDelivery(String value) {
        this.expectedDelivery = value;
    }

}
