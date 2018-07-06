package com.concurrent;

import com.lst.utils.Result;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTaskDemo extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public CountTaskDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end-start)<THRESHOLD;
        if (canCompute){
            for (long i = start ;i <=end;i++){
                sum += i;
            }
        }else {
            long step = (start+end)/100;
            ArrayList<CountTaskDemo> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0;i<100;i++){
                long lastOne = pos +step;
                if (lastOne >end)lastOne = end;
                CountTaskDemo subTask = new CountTaskDemo(pos,lastOne);
                pos += step +1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (CountTaskDemo t : subTasks){
                sum += t.join();
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTaskDemo countTaskDemo = new CountTaskDemo(0, 20000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(countTaskDemo);
        try {
            long res = submit.get();
            System.out.println("sum"+res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
