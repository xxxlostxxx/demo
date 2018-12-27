/*
package com.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisruptorMain {
    public static void main(String[] args) {
         // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //等待策略
        WaitStrategy blockingWaitStrategy = new BlockingWaitStrategy();
        WaitStrategy sleepingWaitStrategy = new SleepingWaitStrategy();
        WaitStrategy yieldingWaitStrategy = new YieldingWaitStrategy();

        //事件工厂
        HelloEventFactory helloEventFactory = new HelloEventFactory();
        //ringBuffer大小，2的次方
        int ringBufferSize = 1024*1024;
        // 创建Disruptor
        Disruptor<HelloEvent> disruptor = new Disruptor<HelloEvent>(helloEventFactory,ringBufferSize,executor, ProducerType.SINGLE
        ,blockingWaitStrategy);

        //事件处理器
        EventHandler<HelloEvent> eventHandler = new HelloEventHandler();
        disruptor.handleEventsWith(eventHandler);

        // 启动disruptor
        disruptor.start();

        // 获取RingBuffer
        RingBuffer<HelloEvent> ringBuffer = disruptor.getRingBuffer();

        // 请求下一个事件序号
        long sequence = ringBuffer.next();

        try {
            // 获取该序号对应的事件对象
            HelloEvent event = ringBuffer.get(sequence);

            // 设置事件内容
            event.setValue("hello - world@!!");
        }finally {

            // 发布事件
            ringBuffer.publish(sequence);
        }

    }
}
*/
