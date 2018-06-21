package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Collections2;

import java.util.LinkedList;

/**
 * Making a stack from a LinkedList.
 * 栈，后进先出
 */
public class StackL {
    private LinkedList list = new LinkedList();

    public void push(Object v){
        list.addFirst(v);
    }

    public Object top(){
        return list.getFirst();
    }

    public Object pop(){
        return list.removeFirst();
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args){
        StackL stackL = new StackL();
        for(int i=0; i<10; i++){
            stackL.push(Collections2.countries.next());
            System.out.println("stack: " + stackL.toString());
        }

//        System.out.println("stack: " + stackL.toString());

        System.out.println(stackL.top());
        System.out.println(stackL.top());
        System.out.println(stackL.pop());
        System.out.println(stackL.pop());
        System.out.println(stackL.pop());
    }
}
