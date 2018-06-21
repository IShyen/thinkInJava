package com.sigar.think.c09.exercises;


public class E02_ExceptionClass extends Exception{
    private String msg;

    public E02_ExceptionClass(String msg){
        this.msg = msg;
    }

    public String toString(){
        return this.getMessage() + " msg: " + this.msg;
    }

    public static void main(String[] args){
        try{
            throw new E02_ExceptionClass("testMsg");
        }catch (E02_ExceptionClass e){
            System.out.println(e);
        }
    }
}
