package com.zy.interview.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {

    }

    private static void take() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("1");
        blockingQueue.put("2");
        blockingQueue.put("3");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    private static void put() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        try {
            blockingQueue.put("1");
            blockingQueue.put("2");
            blockingQueue.put("3");
            blockingQueue.put("4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void poll() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("1");
        blockingQueue.offer("2");
        blockingQueue.offer("3");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.poll());
    }

    private static void offer() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        // 设置超时时间为2s，TimeUnit是时间颗粒度转换，TimeUnit.SECOND代表秒
        System.out.println(blockingQueue.offer("1", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("2", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("3", 2L, TimeUnit.SECONDS));
        // true true true
        System.out.println(blockingQueue.offer("4", 2L, TimeUnit.SECONDS));
        // false
    }

    private static void element() {
        // 构造方法传参是规定其长度
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add("1");
        blockingQueue.add("2");
        blockingQueue.add("3");

        System.out.println(blockingQueue.element());
    }

    private static void remove() {
        // 构造方法传参是规定其长度
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add("1");
        blockingQueue.add("2");
        blockingQueue.add("3");

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        System.out.println(blockingQueue.remove());
    }

    private static void add() {
        // 构造方法传参是规定其长度
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("2"));
        System.out.println(blockingQueue.add("3"));

        System.out.println(blockingQueue.add("4"));
        // java.lang.IllegalStateException: Queue full
    }

}
