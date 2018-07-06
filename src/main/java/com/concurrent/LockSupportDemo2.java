package com.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo2 {
    public static Object u  =  new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class  ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name) {
            super.getName();
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in  "+getName());
            }
            LockSupport.park();
            if (Thread.interrupted()){
                System.out.println(getName()+" 被中断");

            }
            System.out.println(getName()+"执行结束");

        }

    }


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(10000);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }


}
