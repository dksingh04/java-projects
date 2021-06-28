package com.dk.threading.impl.seamaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSemaphore {
    public static void main(String ...args){
        ExecutorService service = Executors.newFixedThreadPool(6);
        try {
            for (int i = 0; i < 4; i++) {
                service.submit(() -> {
                    try {
                        run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }catch(Exception e){
            System.out.println("Some Exception!");
        }finally{
            service.shutdown();
        }



    }

    private static void run() throws InterruptedException {
        AllowNThreadsForSpecificMethods resource = new AllowNThreadsForSpecificMethods();
        resource.limitedResource();

        Thread.sleep(5000);
        resource.releaseResource();
    }
}
