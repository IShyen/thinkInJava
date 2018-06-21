package com.sigar.think.c13.exercises;

/******************** Exercise 1 ********************
 * Implement a Runnable. Inside run(). Print a
 * message. and then call yield(). Repeat this
 * three times. and then return for run(). Put
 * a startup message in the constructor and a
 * shutdown message when the task terminates. Create
 * a number of these task and drive them using
 * threads.
 ****************************************************/
class Printer implements Runnable{
    private static int taskCount;
    private final int id = taskCount++;

    Printer(){
        System.out.println("Printer started. ID = " + id);
    }

    /**
     * 为什么 sleep()方法和yield()方法是静态的？
     * sleep(）和yield()属于类方法而不是实例方法。
     * 因为这个方法作用是使当前线程休眠，而与具体线程类实例无关
     */
    public void run(){
        System.out.println("Stage 1....ID = " + id);
        Thread.yield();
        System.out.println("Stage 2....ID = " + id);
        Thread.yield();
        System.out.println("Stage 3....ID = " + id);
        Thread.yield();
        System.out.println("Printer ended. ID = " + id);
    }
}

public class E01_Runnable {
    public static void main(String[] args){
        for(int i=0; i<5; i++){
            new Thread(new Printer()).start();
        }
    }
}
