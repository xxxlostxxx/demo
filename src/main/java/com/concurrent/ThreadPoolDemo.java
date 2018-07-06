package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
           //  System.out.println(System.currentTimeMillis()+ ": Thread ID:"+Thread.currentThread().getId());
            try {
               // IntDemo.writer();
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    public static class MyTask1 implements Runnable {

        @Override
        public void run() {
            //  System.out.println(System.currentTimeMillis()+ ": Thread ID:"+Thread.currentThread().getId());
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            IntDemo.writer();


        }
    }

    public static class MyTask2 implements Runnable {

        @Override
        public void run() {
            //  System.out.println(System.currentTimeMillis()+ ": Thread ID:"+Thread.currentThread().getId());

                IntDemo.reader();

        }
    }
    public static void main(String[] args) {
        MyTask1 task1 = new MyTask1();
        MyTask2 task2 = new MyTask2();

        ExecutorService es = Executors.newScheduledThreadPool(20);
       // ExecutorService es = Executors.newFixedThreadPool(5);
       // ExecutorService es = Executors.newFixedThreadPool(5);
        es.submit(task1);
        for (int i= 0;i<100;i++){
            es.submit(task2);
        }

    }
}
