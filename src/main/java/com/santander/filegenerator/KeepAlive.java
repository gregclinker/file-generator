package com.santander.filegenerator;

public class KeepAlive implements Runnable {

	public void run() {
		while (true) {
			try {
				System.out.println("keep alive thread");
				Thread.sleep(10000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
