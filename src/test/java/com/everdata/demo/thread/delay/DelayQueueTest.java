package com.everdata.demo.thread.delay;

import java.util.concurrent.DelayQueue;

public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<DelayedElement>();

        //生产者
        producer(delayQueue);

        //消费者
        consumer(delayQueue);

        Thread.sleep(Integer.MAX_VALUE);
    }

    /**
     * 每秒生产一个对象，每个对象被取出来的延迟时间是3秒
     */
    private static void producer(final DelayQueue<DelayedElement> delayQueue){
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    DelayedElement element = new DelayedElement(3000,"test");
                    delayQueue.offer(element);
                }
            }
        }).start();

        /**
         * 每3秒打印延迟队列中的对象个数
         */
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("delayQueue size:"+delayQueue.size());
                }
            }
        }).start();
    }

    /**
     * 消费者，从延迟队列中获得数据,进行处理
     * @param delayQueue
     */
    private static void consumer(final DelayQueue<DelayedElement> delayQueue){
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    DelayedElement element = null;
                    try {
                        element =  delayQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis()+"---"+element);
                }
            }
        }).start();
    }
}