package com.dk.threading.impl.threads;

import com.dk.threading.impl.basic.pc.PCMessagingQueue;

public class ConsumerThread<T> implements Runnable{

    private PCMessagingQueue<T> messageQueue;

    public ConsumerThread(PCMessagingQueue<T> messageQueue){
        this.messageQueue = messageQueue;
    }
    @Override
    public void run() {

        try {
            T message = messageQueue.consume();
            System.out.println("Consumed : "+ message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
