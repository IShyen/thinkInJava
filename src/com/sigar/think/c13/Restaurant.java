package com.sigar.think.c13;

/**
 * Copyright (c) 2017 yusijia0501@126.com. All rights reserved.
 * Created by yusijia0501@126.com on 2017/3/20.
 * 餐厅厨师和服务员
 * 模仿 生产者/消费者
 */

// 命令类
class Order{
    private static int i = 0;
    private int count = i++;

    public Order(){
        if(count == 10){
            System.out.println("out of food, closing");
            System.exit(0);
        }
    }

    public String toString(){
        return "order: " + count;
    }
}

// 服务员
class WaitPerson extends Thread{
    private Restaurant restaurant;

    public WaitPerson(Restaurant r){
        restaurant = r;
        start();
    }

    public void run(){
        while (true){
            while (restaurant.order == null){
                synchronized (this){
                    try {
                        wait();
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }

            System.out.println("Waitperson got " + restaurant.order);
            restaurant.order = null;
        }
    }
}

// 厨师
class Chef extends Thread{
    private Restaurant restaurant;
    private WaitPerson waitPerson;


    public Chef(Restaurant r, WaitPerson w){
        restaurant = r;
        waitPerson = w;
        start();
    }

    public void run(){
        while (true){
            if (restaurant.order == null){
                restaurant.order = new Order();
                System.out.print("Order up! ");
                synchronized (waitPerson){
                    waitPerson.notify();
                }
            }

            try{
                sleep(2000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}

public class Restaurant {
    Order order;

    public static void main(String[] args){
        Restaurant restaurant = new Restaurant();
        WaitPerson waitPerson = new WaitPerson(restaurant);
        Chef chef = new Chef(restaurant, waitPerson);
    }
}
