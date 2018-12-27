package com.anno;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {

    public Demo1() {
        new Demo2();
        System.out.println("demo1");
    }

    class Demo2{
        public Demo2() {
            System.out.println("demo2");
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        new Thread(() ->{
            try {
                System.out.println(3333);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(1234);
                lock.unlock();
            }
        }).start();


    }
}
