package ch14.ex14_09;

public class ThreadGroupTest {
	static ThreadGroup createThreadGroup(ThreadGroup parent, String name) {
		return new ThreadGroup(parent, name);
	}

	static void createThread(ThreadGroup parent, String name) {
		new Thread(parent, name) {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					return;
				}
			}
		}.start();
	}

	static void showTreadGroup(final ThreadGroup grp) {
		new Thread() {
			public void run() {
				for (;;) {
					try {
						System.out.println(grp.getName());
						ThreadGroupTest.show(grp);
						Thread.sleep(2000);
					} catch (InterruptedException e)  {
						return;
					}
		        }
			}
		}.start();
	}

	private static final void show(ThreadGroup tgrp) {
		ThreadGroup[] threadGroups = new ThreadGroup[1000];
		Thread[] threads = new Thread[1000];

		tgrp.enumerate(threadGroups, false);
		tgrp.enumerate(threads, false);

		for (ThreadGroup tg : threadGroups) {
			if (tg != null) {
				System.out.println(tg.getName());
				show(tg);
			}
		}

		for (Thread thread : threads) {
			if (thread != null) {
				System.out.println(thread.getName());
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
		ThreadGroupTest.showTreadGroup(mainThreadGroup);

		ThreadGroup myThreadGroup = ThreadGroupTest.createThreadGroup(mainThreadGroup, "myThreadGroup");

		try {
			ThreadGroupTest.createThread(myThreadGroup, "Thread1");
			Thread.sleep(3000);
			ThreadGroupTest.createThread(mainThreadGroup, "Thread2");
			Thread.sleep(3000);
			ThreadGroupTest.createThread(myThreadGroup, "Thread3");
		} catch (InterruptedException e) {
			return;
		}
	}
}
