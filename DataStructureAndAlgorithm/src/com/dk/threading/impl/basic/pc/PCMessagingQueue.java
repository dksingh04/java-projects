package com.dk.threading.impl.basic.pc;

public interface PCMessagingQueue<T> {

    void produce(T message) throws InterruptedException;
    T consume() throws InterruptedException;

}
