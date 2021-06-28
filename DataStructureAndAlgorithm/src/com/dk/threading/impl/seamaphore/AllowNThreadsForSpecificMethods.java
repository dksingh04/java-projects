package com.dk.threading.impl.seamaphore;

import java.util.concurrent.Semaphore;

public class AllowNThreadsForSpecificMethods {
    static Semaphore allowedPermits = new Semaphore(3);

    public void limitedResource() throws InterruptedException {
        allowedPermits.acquire();
        System.out.println("Thread "+Thread.currentThread().getName()+" Is working now!");
        Thread.sleep(1000);
        System.out.println("Allowed Permits "+allowedPermits.availablePermits());
    }

    public void releaseResource(){
        allowedPermits.release();
    }
}
