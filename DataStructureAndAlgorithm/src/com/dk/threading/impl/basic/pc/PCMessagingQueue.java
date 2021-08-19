package com.dk.threading.impl.basic.pc;

import java.util.List;

public abstract class PCMessagingQueue<T> {

    public abstract void produce(T message) throws InterruptedException;
    public abstract T consume() throws InterruptedException;

}
