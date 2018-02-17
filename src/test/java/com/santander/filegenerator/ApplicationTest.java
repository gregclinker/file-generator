package com.santander.filegenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
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
		create.setCount(3);
		create.setIntitalWait(1000l);
		create.setThreads(2);
		create.setSize(10);

		CreateSet createSet = new CreateSet();
		createSet.getCreates().add(create);

		new Application().runCreate(createSet);

		for (int i = 0; i < 3; i++) {
			assertTrue(new File("testBase_" + i).delete());
		}
	}
}
