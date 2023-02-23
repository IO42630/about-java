package com.olexyn.about.java.xml.ws.handler;

import java.util.HashMap;

import javax.xml.ws.handler.MessageContext;

public class AMessageContext extends HashMap<String, Object> implements MessageContext {

	@Override
	public void setScope(String name, Scope scope) {
	}

	@Override
	public Scope getScope(String name) {
		return null;
	}

}
