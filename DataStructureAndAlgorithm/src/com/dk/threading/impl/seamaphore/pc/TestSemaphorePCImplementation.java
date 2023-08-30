package com.dk.threading.impl.seamaphore.pc;

import com.dk.threading.impl.basic.pc.PCMessagingQueue;
import com.dk.threading.impl.threads.ConsumerThread;
import com.dk.threading.impl.threads.ProducerThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSemaphorePCImplementation {
    public static void main(String ...args){
        ExecutorService producerService = Executors.newFixedThreadPool(5);

        ExecutorService consumerService = Executors.newFixedThreadPool(5);
        PCMessagingQueue<Integer> messageQueuenew = new SemaPhorePCMessagingQueue<>();

        for(int i = 1; i <= 20; i++){
            ProducerThread<Integer> producerThread = new ProducerThread<>(messageQueuenew, i);
            producerService.submit(producerThread);
        }

        for(int i = 1; i <= 8; i++){
            ConsumerThread<Integer> consumerThread = new ConsumerThread<>(messageQueuenew);
            consumerService.submit(consumerThread);
        }


    }
}
