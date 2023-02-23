package com.olexyn.about.java.xml.ws.handler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

public class AHandler implements Handler<MessageContext> {

	@Override
	public boolean handleMessage(MessageContext context) {
		return false;
	}

	@Override
	public boolean handleFault(MessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {
	}

}
