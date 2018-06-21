package com.sigar.think.c09.exercises;

public class E01_SimpleException {
    public static void main(String[] args){
        try{
            throw new Exception("A exception in main.");
        }catch (Exception e){
            System.out.println("e.getMessage():" + e.getMessage());
        }finally {
            System.out.println("in finally clause");
        }
    }
}
