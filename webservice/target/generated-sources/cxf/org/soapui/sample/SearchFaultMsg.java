
package org.soapui.sample;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.3.7
 * 2020-09-27T23:12:08.087+02:00
 * Generated source version: 3.3.7
 */

@WebFault(name = "searchFault", targetNamespace = "http://www.w3.org/2001/XMLSchema")
public class SearchFaultMsg extends Exception {

    private java.lang.String searchFault;

    public SearchFaultMsg() {
        super();
    }

    public SearchFaultMsg(String message) {
        super(message);
    }

    public SearchFaultMsg(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SearchFaultMsg(String message, java.lang.String searchFault) {
        super(message);
        this.searchFault = searchFault;
    }

    public SearchFaultMsg(String message, java.lang.String searchFault, java.lang.Throwable cause) {
        super(message, cause);
        this.searchFault = searchFault;
    }

    public java.lang.String getFaultInfo() {
        return this.searchFault;
    }
}
