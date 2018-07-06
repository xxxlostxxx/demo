package com.disruptor;

import com.lmax.disruptor.EventHandler;

public class HelloEventHandler implements EventHandler<HelloEvent> {

    @Override
    public void onEvent(HelloEvent helloEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(helloEvent.getValue());
    }
}
