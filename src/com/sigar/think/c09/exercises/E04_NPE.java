package com.sigar.think.c09.exercises;

public class E04_NPE {
    public static void main(String[] args){
        Object o = null;
        try{
            o.getClass();
        }catch (Exception e){
            System.err.println("Caught exception: " + e);
        }
    }
}
