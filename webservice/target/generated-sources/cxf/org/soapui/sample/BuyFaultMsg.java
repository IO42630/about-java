
package org.soapui.sample;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.3.7
 * 2020-09-27T23:12:08.099+02:00
 * Generated source version: 3.3.7
 */

@WebFault(name = "buyFault", targetNamespace = "http://www.w3.org/2001/XMLSchema")
public class BuyFaultMsg extends Exception {

    private java.lang.String buyFault;

    public BuyFaultMsg() {
        super();
    }

    public BuyFaultMsg(String message) {
        super(message);
    }

    public BuyFaultMsg(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public BuyFaultMsg(String message, java.lang.String buyFault) {
        super(message);
        this.buyFault = buyFault;
    }

    public BuyFaultMsg(String message, java.lang.String buyFault, java.lang.Throwable cause) {
        super(message, cause);
        this.buyFault = buyFault;
    }

    public java.lang.String getFaultInfo() {
        return this.buyFault;
    }
}
