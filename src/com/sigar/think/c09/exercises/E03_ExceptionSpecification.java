package com.sigar.think.c09.exercises;

public class E03_ExceptionSpecification {
    public static void f() throws E02_ExceptionClass{
        throw new E02_ExceptionClass("Exception in f()");
    }

    public static void main(String[] args){
        try{
            f();
        }catch (E02_ExceptionClass e){
            System.out.println(e);
        }
    }
}
