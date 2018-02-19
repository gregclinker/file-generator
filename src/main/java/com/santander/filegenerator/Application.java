package com.santander.filegenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class Application {

	final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("");
			System.out.println("Usage create <test.xml>");
			System.out.println("");
			System.exit(0);
		}
		try {
			new Thread(new KeepAlive()).start();
			Application application = new Application();
			CreateSet createSet = application.parse(new FileInputStream(args[0]));
			application.runCreate(createSet);
			application.report(createSet);
		} catch (Exception e) {
			LOGGER.error("something bad happened", e);
		}
	}

	private void report(CreateSet createSet) {
		// TODO Auto-generated method stub
	}

	public CreateSet parse(InputStream inputStream) throws SAXException, ParserConfigurationException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

		factory.setSchema(schemaFactory.newSchema(new StreamSource(getClass().getResourceAsStream("/tests.xsd"))));

		SAXParser parser = factory.newSAXParser();
		CreateHandler testsHandler = new CreateHandler();
		parser.parse(inputStream, testsHandler);
		return testsHandler.getCreateSet();
	}

	public void runCreate(CreateSet createSet) throws InterruptedException {

		for (Create create : createSet.getCreates()) {
			LOGGER.debug("started " + create);
			for (int i = 0; i < create.getCount(); i++) {
				String fileName = create.getBaseName() + "_" + i;
				if (create.getIntitalWait() > 0) {
					LOGGER.debug("waiting " + create.getIntitalWait() + " to create " + fileName);
					Thread.sleep(create.getIntitalWait());
				}
				new Thread(new RandomFile(fileName, create.getSize())).start();
			}
			LOGGER.debug("finished starting threads");
		}
	}
}
