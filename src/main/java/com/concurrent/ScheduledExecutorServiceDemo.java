package com.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(8000);
                System.out.println(System.currentTimeMillis()/1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },0,2, TimeUnit.SECONDS);
    }
}
