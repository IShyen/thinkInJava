package com.sigar.think.c09.exercises;

class NewException extends Exception{}
class NewException2 extends Exception{}


public class E05_ChangeException {
    /**
     * E05
     */
//    public void f() throws NewException2{
//        try{
//            g();
//        }catch (NewException e){
//            throw new NewException2();
//        }
//    }

    /**
     * E06
     */
    public void f(){
        try{
            g();
        }catch (NewException e){
            throw new RuntimeException("Exception in f()");
        }
    }

    public void g() throws NewException{
        throw new NewException();
    }

    public static void main(String[] args){
        E05_ChangeException e05 = new E05_ChangeException();
        try{
            e05.g();
        }catch (NewException e){
            System.err.println("Caught exception: " + e);
            e.printStackTrace();
        }
        System.err.println("**************************************");
        // E05
//        try{
//            e05.f();
//        }catch (NewException2 e){
//            System.err.println("Caught exception: " + e);
//            e.printStackTrace();
//        }

        // E06
        try{
            e05.f();
        }catch (RuntimeException e){
            System.err.println("Caught exception: " + e);
            e.printStackTrace();
        }
    }
}
