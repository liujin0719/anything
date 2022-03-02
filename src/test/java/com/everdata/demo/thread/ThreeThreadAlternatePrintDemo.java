package com.everdata.demo.thread; /**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

import java.util.concurrent.TimeUnit;

/**
 * ThreeThreadAlternatePrintDemo
 *
 * @author liujin
 * @date 2022/1/14 上午10:32
 */
public class ThreeThreadAlternatePrintDemo {

	public static void main(String[] args) throws InterruptedException {

		Object l1 = new Object();
		Object l2 = new Object();
		Object l3 = new Object();

		Print print1 = new Print(l3, l1);
		Print print2 = new Print(l1, l2);
		Print print3 = new Print(l2, l3);
		new Thread(print1).start();
		TimeUnit.SECONDS.sleep(1);
		new Thread(print2).start();
		TimeUnit.SECONDS.sleep(1);
		new Thread(print3).start();

	}

	static class Print implements Runnable {

		private final Object pre;
		private final Object self;

		public Print(Object pre, Object self) {
			this.pre = pre;
			this.self = self;
		}

		private static transient int count = 0;

		@Override
		public void run() {
			while (count < 100) {
				synchronized (pre) {
					synchronized (self) {
						System.out.println(Thread.currentThread().getName() + ":" + count);
						count++;
						self.notify();
					}
					pre.notify();
					try {
						pre.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}