package com.sigar.think.c09.exercises;


public class E08_ArrayIndexBounds {
    public static void main(String[] args){
        char[] chars = new char[10];
        try{
            chars[10] = 'x';
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Caught exception: " + e);
            e.printStackTrace();
        }
    }
}
