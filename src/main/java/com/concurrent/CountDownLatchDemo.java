package com.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements  Runnable{




    static final CountDownLatchDemo demo = new CountDownLatchDemo();


    public static void run( CountDownLatch end ) {
       try {
           Thread.sleep(new Random().nextInt(10)*1000);
           System.out.println("check complete");
           end.countDown();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch end = new CountDownLatch(10);

        for (int i = 0 ; i<10;i++) {
            executorService.submit(() -> run(end));
        }
        end.await();
        System.out.println("fire");
        executorService.shutdown();
    }

    @Override
    public void run() {

    }
}
