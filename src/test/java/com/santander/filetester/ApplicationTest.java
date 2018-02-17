package com.santander.filetester;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ApplicationTest {

	@Test
	public void parse() throws SAXException, ParserConfigurationException, IOException {
		Application application = new Application();
		CreateSet createSet = application.parse(getClass().getResourceAsStream("/tests.xml"));
		assertEquals(2, createSet.getCreates().size());
	}

	@Test
	public void create() throws InterruptedException {
		Create create = new Create();
		create.setBaseName("testBase");
		create.setCount(5);
		create.setIntitalWait(1000l);
		create.setThreads(2);
		create.setSize(10);
		
		CreateSet createSet = new CreateSet();
		createSet.getCreates().add(create);
		
		new Application().runCreate(createSet);
	}
}
