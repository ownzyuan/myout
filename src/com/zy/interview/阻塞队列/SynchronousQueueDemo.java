package com.zy.interview.阻塞队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue queue = new SynchronousQueue();

        // 生产者线程
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                queue.put("1");

                System.out.println(Thread.currentThread().getName() + "\t put 2");
                queue.put("2");

                System.out.println(Thread.currentThread().getName() + "\t put 3");
                queue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "provider").start();

        // 消费者线程
        new Thread(() -> {
            try {
                // 每次消费前先睡眠2秒钟
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());

                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());

                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        // 程序执行结果：
        // provider	 put 1
        // consumer	1
        // provider	 put 2
        // consumer	2
        // provider	 put 3
        // consumer	3
    }
}
