
package org.soapui.sample;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.soapui.sample package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.soapui.sample
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchResponseContent }
     * 
     */
    public SearchResponseContent createSearchResponseContent() {
        return new SearchResponseContent();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link BuyResponseContent }
     * 
     */
    public BuyResponseContent createBuyResponseContent() {
        return new BuyResponseContent();
    }

    /**
     * Create an instance of {@link PurchaseStatusType }
     * 
     */
    public PurchaseStatusType createPurchaseStatusType() {
        return new PurchaseStatusType();
    }

}
