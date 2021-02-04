package com.zy.面试.集合不安全问题;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeDemo {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        // java.util.ConcurrentModificationException
        // 当方法检测到对象的并发修改，但不允许这种修改时，抛出此异常。
    }

}
