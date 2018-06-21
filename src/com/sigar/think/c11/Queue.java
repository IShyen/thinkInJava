package com.sigar.think.c11;

import java.util.LinkedList;

/**
 * Making a queue from a LinkedList
 * 队列：先进先出
 */
public class Queue {
    private LinkedList list = new LinkedList();

    public void put(Object v){
        list.addFirst(v);
    }

    public Object get(){
        return list.removeLast();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args){
        Queue queue = new Queue();
        for(int i=0; i<10; i++){
            queue.put(Integer.toString(i));
            System.out.println("stack: " + queue.toString());
        }
        while (!queue.isEmpty()){
            System.out.println(queue.get());
        }
    }
}
