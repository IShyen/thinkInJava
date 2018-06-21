package com.sigar.think.c09.exercises;

class MyException1 extends Exception{}
class MyException2 extends Exception{}
class MyException3 extends Exception{}

public class E07_CatchAll {
    public void f() throws MyException1,MyException2,MyException3{
        throw new MyException1();
    }

    public static void main(String[] args){
        E07_CatchAll e07 = new E07_CatchAll();
        try{
            e07.f();
        }catch (Exception e){
            System.err.println("Caught exception: " + e);
        }
    }
}
