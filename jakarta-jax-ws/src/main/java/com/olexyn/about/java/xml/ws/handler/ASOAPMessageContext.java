package com.olexyn.about.java.xml.ws.handler;

import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class ASOAPMessageContext extends AMessageContext implements SOAPMessageContext {

	private static final long serialVersionUID = 4238102658079663253L;


	@Override
	public SOAPMessage getMessage() {
		return null;
	}

	@Override
	public void setMessage(SOAPMessage message) {

	}

	@Override
	public Object[] getHeaders(QName header, JAXBContext context, boolean allRoles) {
		return new Object[0];
	}

	@Override
	public Set<String> getRoles() {
		return null;
	}

}
