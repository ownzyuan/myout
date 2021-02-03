package com.zy.面试;

import java.util.concurrent.TimeUnit;

class MyData {
    volatile int number = 0;

    public void add() {
        this.number = 60;
    }

    // 此时number是有volatile修饰的
    public void addPlus() {
        number++;
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlus();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value:" + myData.number);

        // main	 finally number value:19909
        // main	 finally number value:18330
        // main	 finally number value:19904
        // 每次运行结果都不相同，所以volatile不保证原子性
    }

    /**
     * 探索可见性
     */
    private static void seeOKByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                // 暂停一下线程
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + myData.number);
        }, "AAA").start();

        // 第2个线程就是main线程
        while (myData.number == 0) {
            // main线程一直在这里等待循环，直到number != 0
        }
//        System.out.println(Thread.currentThread().getName()+"\t mission is over");
        System.out.println(Thread.currentThread().getName() + "\t mission is over, number value:" + myData.number);

        // 结果：
        // AAA	 come in
        // AAA	 updated number value:60

        // 加了volatile关键字的结果：
        // AAA	 come in
        // AAA	 updated number value:60
        // main	 mission is over, number value:60
    }

}
