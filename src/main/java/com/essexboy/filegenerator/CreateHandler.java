package com.essexboy.filegenerator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CreateHandler extends DefaultHandler {

	private CreateSet createSet = new CreateSet();

	public CreateSet getCreateSet() {
		return createSet;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("create".equals(qName)) {
			Create create = new Create();
			create.setBaseName(attributes.getValue("name"));
			create.setSize(Integer.parseInt(attributes.getValue("size")));
			create.setCount(Integer.parseInt(attributes.getValue("count")));
			create.setIntitalWait(Long.parseLong(attributes.getValue("initial-wait")));
			// create.setThreads(Integer.parseInt(attributes.getValue("threads")));
			createSet.getCreates().add(create);
		}
	}
}
