package com.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable{
 public static ReentrantLock lock =   new ReentrantLock();
 public static int i = 0;


    @Override
    public void run() {
        for (int j=0;j<100000;j++){
            // 使用重入锁保护临界区资源，保证多线程对i操作的安全性
            lock.lock();
            try {
                i++;
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo reentrantLock = new ReentrantLockDemo();
        Thread thread1 = new Thread(reentrantLock);
        Thread thread2 = new Thread(reentrantLock);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}