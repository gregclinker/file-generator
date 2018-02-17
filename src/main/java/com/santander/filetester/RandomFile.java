package com.santander.filetester;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.time.StopWatch;

public class RandomFile implements Runnable {

	private String fileName;
	private Integer size;

	private Random random = new Random();
	private static final int MB = 1024 * 1024;
	private static final int KB = 1024;

	public RandomFile(String fileName, Integer size) {
		this.fileName = fileName;
		this.size = size * 1024;
	}

	public void generate() {
		BufferedOutputStream outputStream = null;
		try {
			StopWatch stopWatch = new StopWatch();
			System.out.println("started create " + fileName + "(size=" + size + "Mb)");
			stopWatch.start();
			File file = new File(fileName);
			outputStream = new BufferedOutputStream(new FileOutputStream(file));
			for (int i = 0; i < size; i++) {
				byte[] bytes = new byte[KB];
				random.nextBytes(bytes);
				outputStream.write(bytes);
			}
			outputStream.close();
			stopWatch.stop();
			System.out
					.println("finished create " + fileName + "(size=" + size + "Mb) in " + stopWatch.getTime() + "ms");
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
