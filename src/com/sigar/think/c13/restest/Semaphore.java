package com.sigar.think.c13.restest;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
public class Semaphore implements Invariant{
    private volatile int semaphore = 0;

    public synchronized boolean available(){
        return semaphore == 0;
    }

    public synchronized void acquire(){
        ++semaphore;
    }

    public synchronized void release(){
        --semaphore;
    }

    @Override
    public InvariantState invariant(){
        int val = semaphore;
        if(val==0 || val==1){
            return new InvariantOK();
        }else{
            return new InvariantFailure(new Integer(val));
        }
    }

    public static void main(String[] args) throws Exception{
        Semaphore sem = new Semaphore();
        new SemaphoreTester(sem);
        new SemaphoreTester(sem);
        new InvariantWatcher(sem).join();
    }
}
