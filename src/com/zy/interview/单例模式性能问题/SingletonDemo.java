package com.zy.interview.单例模式性能问题;

public class SingletonDemo {

    private static SingletonDemo instance = null;

    public SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 构造方法SingletonDemo");
    }

    public static SingletonDemo getInstance() {
//    public static synchronized SingletonDemo getInstance() {
//        synchronized 可以解决单例模式的性能问题，但违背了单例模式
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        // 单线程模式下
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        // 结果：
        // main	 构造方法SingletonDemo
        // true
        // true
        // true
        // true

        // 并发环境
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
        // 结果
        // 1	 构造方法SingletonDemo
        // 6	 构造方法SingletonDemo
        // 5	 构造方法SingletonDemo
        // 4	 构造方法SingletonDemo
        // 3	 构造方法SingletonDemo
        // 2	 构造方法SingletonDemo
        // 每次运行结果条数、顺序都不相同，出现了性能问题
    }

}
