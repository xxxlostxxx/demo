package com.concurrent;

import com.concurrent.ThreadPoolDemo.MyTask1;
import com.concurrent.ThreadPoolDemo.MyTask2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 防止等待队列过长
 * 是否必须
 * @author youzhu@dian.com.so
 * @version 1.0.0
 * @Date 2018-12-27
 */
public class 固定执行数量 {

    private static AtomicInteger num = new AtomicInteger(0);

    public static  void runDemo(Integer i) {
        //  System.out.println(System.currentTimeMillis()+ ": Thread ID:"+Thread.currentThread().getId());
           // System.out.println(i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            num.getAndAdd(-1);
        }

            // IntDemo.writer();

    }


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Integer> list =new ArrayList();
        int i = 1;
        while (i<10000) {
            list.add(i);
            i++;
        }
        int k =1;
        while (k<9999) {
            Integer integer = list.get(k);
            if (num.get() <5) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        runDemo(integer);
                    }
                });
                num.getAndAdd(1);
                System.out.println(num.get());
                k++;
            } else {
                System.out.println("线程已满");
            }
            Thread.sleep(49);
        }


    }

}
