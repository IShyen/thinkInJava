package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Arrays2;
import com.sigar.think.bruceeckel.util.Generator;

import java.util.Arrays;
import java.util.Random;

/**
 * Implementing Comparable in a class.
 */
public class CompType implements Comparable{
    int i;
    int j;

    public CompType(int n1, int n2){
        i = n1;
        j = n2;
    }

    public String toString(){
        return "[i = " + i + ", j = " + j + "]";
    }

    public int compareTo(Object rv){
        int rvi = ((CompType)rv).i;
        return (i < rvi ? -1 : (i == rvi ? 0 : 1));
    }

    private static Random r = new Random();
    public static Generator generator(){
        return new Generator(){
            public Object next(){
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    public static void main(String[] args){
        CompType[] a = new CompType[10];
        Arrays2.fill(a,generator());
        System.out.println("before sorting, a = " + Arrays.asList(a));
        Arrays.sort(a);
        System.out.println("after sorting, a = " + Arrays.asList(a));
    }
}
