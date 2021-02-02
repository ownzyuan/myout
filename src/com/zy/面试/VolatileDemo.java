package com.zy.面试;

import java.util.concurrent.TimeUnit;

class MyData {
    int number = 0;

    public void add() {
        this.number = 60;
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
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
        while (myData.number == 0){
            // main线程一直在这里等待循环，直到number != 0
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }

    // 结果：
    // AAA	 come in
    // AAA	 updated number value:60
}
