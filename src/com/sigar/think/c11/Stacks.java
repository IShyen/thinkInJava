package com.sigar.think.c11;

import com.sigar.think.c08.Month;

import java.util.Stack;

/**
 * Demonstration of Stack Class.
 */
public class Stacks {
    public static void main(String[] args){
        Stack stack = new Stack();
        for(int i=0; i< Month.month.length; i++){
            stack.push(Month.month[i]);
        }
        System.out.println("stack = " + stack);
        // Treating a stack as a Vector
        stack.addElement("The last line");
        System.out.println("element 5 = " + stack.elementAt(5));
        System.out.println("popping elements: ");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
