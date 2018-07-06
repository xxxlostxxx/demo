package com.concurrent;

import java.util.concurrent.*;

public class DaemonThreadDemo {


    public static void main(String[] args) throws InterruptedException {
        RejectThreadPoolDemo.MyTask task = new RejectThreadPoolDemo.MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        System.out.println("create "+t);
                        return t;
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "is discard");
                    }
                }
        );

        for (int i = 0; i<5;i++){
            es.submit(task);
        }
        Thread.sleep(2000);
    }


}
