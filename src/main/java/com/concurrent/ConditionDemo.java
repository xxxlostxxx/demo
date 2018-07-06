package com.concurrent;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo implements Runnable{

    public static ReentrantLock lock =  new ReentrantLock();
    public static Condition condition = lock.newCondition();





    public static void main(String[] args) throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo();
        Thread t1 = new Thread(conditionDemo);
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("thread is going on");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
