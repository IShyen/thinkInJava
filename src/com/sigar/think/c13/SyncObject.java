package com.sigar.think.c13;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/12.
 */
class DualSynch{
    private Object syncObject = new Object();

    public synchronized void f(){
        System.out.println("Inside f()");

        // Doesn't release lock:
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println("Leaving f()");
    }

    public void g(){
        synchronized (syncObject){
            System.out.println("Inside g()");
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            System.out.println("Leaving g()");
        }
    }
}

public class SyncObject {
    public static void main(String[] args){
        final DualSynch ds = new DualSynch();

        new Thread(){
            public void run(){
                ds.f();
            }
        }.start();

        ds.g();
    }
}
