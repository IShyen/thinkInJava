package com.sigar.think.c11;


import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
    public String toString(){
        return "InfiniteRecursion address: " + this + "\n";
    }

    public static void main(String[] args){
//        List v = new ArrayList();
//        for(int i=0; i<10; i++){
//            v.add(new InfiniteRecursion());
//        }
//        System.out.println(v);
        System.out.println(new InfiniteRecursion());
    }
}
