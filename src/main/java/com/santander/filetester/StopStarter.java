package com.santander.filetester;

public class StopStarter implements Runnable {

	private Thread thread;
	private String name;
	private Long interval = -1l;
	private Long intervalWait = 0l;

	public StopStarter(Thread thread, String name, Long interval, Long intervalWait) {
		super();
		this.thread = thread;
		this.name = name;
		this.interval = interval;
		this.intervalWait = intervalWait;
	}

	public void run() {
		try {
			while (thread.isAlive()) {
				if (interval > 0) {
					System.out.println("running for " + interval + "ms for " + name);
					Thread.sleep(interval);
					System.out.println("about to wait " + intervalWait + "ms for " + name);
					synchronized (thread) {
						thread.wait(intervalWait);
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
