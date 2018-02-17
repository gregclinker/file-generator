package com.santander.filetester;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class RandomFileTest {

	@Test
	public void test1() throws IOException {
		String fileName = "test1";
		RandomFile randomFile = new RandomFile(fileName, 10);
		randomFile.generate();
		
		File file = new File(fileName);
		assertTrue(file.exists());
		assertTrue(file.delete());
	}
}
