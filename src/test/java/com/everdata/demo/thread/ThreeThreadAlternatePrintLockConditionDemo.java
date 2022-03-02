/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockCondition
 * 测试ReentrantLock的Condition
 * @author liujin
 * @date 2022/1/14 下午4:17
 */
public class ThreeThreadAlternatePrintLockConditionDemo {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition conditionA = lock.newCondition();
		Condition conditionB = lock.newCondition();
		Condition conditionC = lock.newCondition();

		new Thread(new Print(lock, conditionC, conditionA)).start();
		new Thread(new Print(lock, conditionA, conditionB)).start();
		new Thread(new Print(lock, conditionB, conditionC)).start();

	}

	public static class Print implements Runnable {

		private static volatile int count = 0;
		ReentrantLock lock;
		Condition conditionA;
		Condition conditionB;

		public Print(ReentrantLock lock, Condition pre, Condition self) {
			this.lock = lock;
			this.conditionA = pre;
			this.conditionB = self;
		}

		@Override
		public void run() {
			while (count < 100) {
				lock.lock();
				try {
					System.out.println(Thread.currentThread().getName() + ":" + count);
					count++;
					conditionB.signal();
					conditionA.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

		}
	}

}