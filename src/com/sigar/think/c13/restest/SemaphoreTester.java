package com.sigar.think.c13.restest;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class SemaphoreTester extends Thread {
    private volatile Semaphore semaphore;

    public SemaphoreTester(Semaphore semaphore){
        this.semaphore = semaphore;
        setDaemon(true);
        start();
    }

    public void run(){
        while (true){
            if(semaphore.available()){
                semaphore.acquire();
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Semaphore sem = new Semaphore();
        new SemaphoreTester(sem);
        new SemaphoreTester(sem);
        new InvariantWatcher(sem).join();
    }
}
