package com.zy.interview.线程池;

import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledThreadPool();
        new WeakHashMap<>();
    }

    private static void ScheduledThreadPool() {
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        try {
            for (int i = 1; i <= 10; i++) {
                scheduledThreadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 处理请求");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scheduledThreadPool.shutdown();
        }
        // 程序运行结果
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
    }

    private static void CachedThreadPool() {
        // 一池 n 个线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10; i++) {
                cachedThreadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 处理请求");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cachedThreadPool.shutdown();
        }
        // 程序运行结果
        // pool-1-thread-1	 处理请求
        // pool-1-thread-2	 处理请求
        // pool-1-thread-3	 处理请求
        // pool-1-thread-4	 处理请求
        // pool-1-thread-5	 处理请求
        // pool-1-thread-6	 处理请求
        // pool-1-thread-7	 处理请求
        // pool-1-thread-8	 处理请求
        // pool-1-thread-10	 处理请求
        // pool-1-thread-9	 处理请求
    }

    private static void SingleThreadExecutor() {
        // 一池 仅有 1个线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            for (int i = 1; i <= 10; i++) {
                singleThreadExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 处理请求");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            singleThreadExecutor.shutdown();
        }
        // 程序运行结果
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
        // pool-1-thread-1	 处理请求
    }

    private static void FixedThreadPool() {
        // 一池5个线程
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        // 模拟10个用户请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                fixedThreadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 处理请求");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fixedThreadPool.shutdown();
        }
        // 程序运行结果
        // pool-1-thread-1  处理请求
        // pool-1-thread-1  处理请求
        // pool-1-thread-1  处理请求
        // pool-1-thread-1  处理请求
        // pool-1-thread-1  处理请求
        // pool-1-thread-1  处理请求
        // pool-1-thread-2  处理请求
        // pool-1-thread-3  处理请求
        // pool-1-thread-4  处理请求
        // pool-1-thread-5  处理请求
    }
}
