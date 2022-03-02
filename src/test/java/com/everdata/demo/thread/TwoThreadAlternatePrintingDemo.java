package com.everdata.demo.thread; /**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

/**
 * MultiThreadDemo
 *
 */
public class TwoThreadAlternatePrintingDemo {

	public static void main(String[] args) {
		Print print = new Print();
		new Thread(print, "线程1").start();
		new Thread(print, "线程2").start();
	}

	static class Print implements Runnable {

		private int count = 0;
		private int num = 100;
		@Override
		public void run() {
			while (count < num) {
				synchronized (this) {
					System.out.println(Thread.currentThread().getName() + ":" + count);
					count++;
					notify();
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

}