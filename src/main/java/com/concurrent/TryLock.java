package com.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {

                while (true) {
                    if (lock1.tryLock()) {
                        try {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {

                            }
                            if (lock2.tryLock()) {
                                try {
                                    System.out.println(Thread
                                            .currentThread().getId() + ": my job is done");
                                } finally {
                                    lock2.unlock();
                                }
                            }
                        } finally {
                            lock1.unlock();
                        }
                    } else {
                        System.out.println("get lock failed");
                    }
                }
            }else {
                while (true) {
                    if (lock2.tryLock()) {
                        try {
                            try {
                                Thread.sleep(500);
                            }catch (InterruptedException e){}
                            if (lock1.tryLock()) {
                                try {
                                    System.out.println(Thread.currentThread()
                                    .getId()+": my job is done");
                                }finally {
                                    lock1.unlock();
                                }
                            }
                        }finally {
                            lock2.unlock();
                        }
                    }
                }
            }


        }catch (Exception e){

        }
    }


    public static void main(String[] args) {
       TryLock t1 = new TryLock(1);
       TryLock t2 = new TryLock(2);

        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);

        thread.start();
        thread1.start();
    }
}
