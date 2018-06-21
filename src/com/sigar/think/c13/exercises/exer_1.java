package com.sigar.think.c13.exercises;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/27.
 */
class RepeatThread extends Thread{
    private int count = 0;

    public RepeatThread(){
        System.out.println("Thread created.");
    }

    @Override
    public void  run(){
        while (++count<=3){
            System.out.println("Print something.");
            try{
                sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void finalize(){
        try{
            super.finalize();
        }catch (Throwable t){
            System.out.println(t.toString());
        }
        System.out.println("Thread end.");
    }
}

class GcThread extends Thread{
    @Override
    public void run(){
        callGc();
        callFinalize();
    }

    private void callGc(){
        System.out.println("Call System.gc()");
        System.gc();
    }

    private void callFinalize(){
        System.out.println("Call System.runFinalization()");
        System.runFinalization();
    }

}

public class exer_1 {
    public static void main(String[] args){
//        RepeatThread rt = new RepeatThread();
//        rt.start();

        GcThread gc = new GcThread();
        gc.start();
    }
}
