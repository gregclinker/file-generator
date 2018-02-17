package com.santander.filegenerator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomFile implements Runnable {

	final static Logger LOGGER = LoggerFactory.getLogger(RandomFile.class);

	private String fileName;
	private Integer size;

	private Random random = new Random();
	private static final int MB = 1024 * 1024;
	private static final int KB = 1024;
	private static final int CHUNK_SIZE = KB;

	public RandomFile(String fileName, Integer size) {
		this.fileName = fileName;
		this.size = size;
	}

	public void generate() {
		BufferedOutputStream outputStream = null;
		try {
			StopWatch stopWatch = new StopWatch();
			LOGGER.debug("started create " + fileName + "(size=" + size + "Mb)");
			stopWatch.start();
			File file = new File(fileName);
			outputStream = new BufferedOutputStream(new FileOutputStream(file, true));
			for (int i = 0; i < (size * (MB / CHUNK_SIZE)); i++) {
				byte[] bytes = new byte[CHUNK_SIZE];
				random.nextBytes(bytes);
				outputStream.write(bytes);
			}
			outputStream.close();
			stopWatch.stop();
			LOGGER.debug("finished create " + fileName + "(size=" + size + "Mb) in " + stopWatch.getTime() + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		generate();
	}
}
