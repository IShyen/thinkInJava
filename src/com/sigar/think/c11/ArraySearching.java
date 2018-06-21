package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Arrays2;

import java.util.Arrays;

public class ArraySearching {
    public static void main(String[] args){
        int[] a = new int[100];
        Arrays2.RandIntGenerator gen = new Arrays2.RandIntGenerator(1000);
        Arrays2.fill(a, gen);
        Arrays.sort(a);
        System.out.println("Sorted array: " + Arrays.asList(a));
        while (true){
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if(location > 0){
                System.out.println("Location of " + r + " is " + location + "] = " + a[location]);
                break;
            }
        }
    }
}
