package com.lst.entity;

import com.alibaba.fastjson.JSON;
import com.lst.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperationDemo {

   static AtomicInteger count=new AtomicInteger(0);
   static AtomicInteger i = new AtomicInteger(0);
    /**
     * 非线程安全 导致输出的count 小于应该输出的值 应该是由于线程进行++时发生多次在同时间往基数上++ 的情况
     * Atomic  会在
     */
   //  static int count=0;
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for(int k=0;k<100;k++){
                // count++;
                HttpClientUtil.executeGet(null, "http://localhost:7123/demo/222", "utf-8");
            }
            for(int k=0;k<100;k++){
                // count++;
                HttpClientUtil.executeGet(null, "http://localhost:7123/demo/111", "utf-8");
            }
            for(int k=0;k<100;k++){
                // count++;
                HttpClientUtil.executeGet(null, "http://localhost:7123/demo/333", "utf-8");
            }
        }
    }
    public static void AtomicIntShow(){
        System.out.println("AtomicIntShow() enter");
        ExecutorService threadpool =   Executors.newFixedThreadPool(10);

        for(int k=0;k<1000;k++){
            threadpool.submit(new AddThread());
        }


         /* output
          * AtomicIntShow() enter
          * result of acumulated sum=100000
          * AtomicIntShow() exit
          */

        System.out.println("result of acumulated sum="+count);
        threadpool.shutdown();
        System.out.println("AtomicIntShow() exit");
        return ;

    }

    public static void main(String[] args) {
        testBean();
/*        HttpClientUtil.HttpResponse httpResponse = HttpClientUtil.executeGet(null, "http://localhost:7123/demo1", "utf-8");
        System.out.println(JSON.toJSONString(httpResponse));*/
    AtomicOperationDemo.AtomicIntShow();
    }

    public static void testBean(){
        Map map = new HashMap();
        map.put("i",i);
        AtomicInteger j = (AtomicInteger)map.get("i");
        boolean equals = j.equals(i);
        int i = j.incrementAndGet();
        System.out.println(equals);
        System.out.println(JSON.toJSONString(map));

    }
}
