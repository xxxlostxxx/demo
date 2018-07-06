package com.concurrent;

import java.util.concurrent.*;

public class TraceThreadPoolExecutorDemo extends ThreadPoolExecutor{
    public TraceThreadPoolExecutorDemo(int corePoolSize, int maximumPoolSize,
                                       long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue){
        super(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }

    private Exception clientTrace(){
        return new Exception("client stack trace");
    }
    private Runnable wrap(final Runnable task,final Exception clientStack,
                          String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                }catch (Exception e){
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }


    public static void main(String[] args) {
        ThreadPoolExecutor pools = new TraceThreadPoolExecutorDemo(0,Integer.MAX_VALUE,0L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());


        /**
         * 错误堆栈可以看到是在哪里提交的任务
         * */
        for (int  i=0;i<5;i++) {
            pools.execute(new DivTask(100,i));
        }
    }
}
