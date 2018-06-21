package com.sigar.think.c13.restest;

import java.util.Random;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/24.
 * 哲学家吃饭问题
 * Demonstrates how deadlock can be hidden in a program.
 * {Args: 5 0 deadlock 4}
 *
 * 为什么不会死锁呢？？？
 */
//筷子
class Chopstick{
    private static int counter = 0;
    private int number = counter++;

    public String toString(){
        return "Chopstick " + number;
    }
}

// 哲学家
class Philosopher extends Thread{
    private static Random rand = new Random();

    private static int counter = 0;
    private int number = counter++;

    private Chopstick leftChopStick;
    private Chopstick rightChopStick;

    static int ponder = 0;  //Package access 包内访问权限


    public Philosopher(Chopstick left, Chopstick right){
        leftChopStick = left;
        rightChopStick = right;
        start();
    }

    public void think(){
        System.out.println(this + " thinking");
        if(ponder > 0){
            try{
                sleep(rand.nextInt(ponder));
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void eat(){
        synchronized (leftChopStick){
            System.out.println(this + " has " + this.leftChopStick + " Waiting for " + this.rightChopStick);
        }
        synchronized (rightChopStick){
            System.out.println(this + " eating");
        }
    }

    public String toString(){
        return "Philosopher " + number;
    }

    public void run(){
        while (true){
            think();
            eat();
        }
    }
}

public class DiningPhilosophers {

    public static void main(String[] args){
        if(args.length < 3){
            System.err.println("usage:\n" + "java DiningPhilosophers numberOfPhilosophers ponderFactor deadlock timeout\n"
            + "A nonzero ponderFactor will generate a random sleep time during think().\n"
            + "If deadlock is not the string 'deadlock', the program will not deadlock.\n"
            + "A nonzero timeout will stop the program after that number of seconds.");
            System.exit(1);
        }

        Philosopher[] philosopher = new Philosopher[Integer.parseInt(args[0])];
        Philosopher.ponder = Integer.parseInt(args[1]);
        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();
        Chopstick first = left;
        int i = 0;
        while (i < philosopher.length - 1){
            philosopher[i++] = new Philosopher(left, right);
            left = right;
            right = new Chopstick();
        }

        if(args[2].equals("deadlock")){
            philosopher[i] = new Philosopher(left, first);
        }else { // Swapping values prevents deadlock.
            philosopher[i] = new Philosopher(first, left);
        }
        // Optionally break out of program.
        if(args.length >= 4){
            int delay = Integer.parseInt(args[3]);
            if(delay != 0){
                new Timeout(delay*1000, "Time out");
            }
        }

    }
}
