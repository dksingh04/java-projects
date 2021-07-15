package com.dk.threading.impl.seamaphore.pc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class MessagingQueue {
    private List<String> message = new ArrayList<>();

    private Semaphore consumer = new Semaphore(0);
    private Semaphore producer = new Semaphore(1);

    public String getMessage (){
        return null;
    }

    public void publishMessage (){
    }

}
