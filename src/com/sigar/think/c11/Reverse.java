package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Arrays2;

import java.util.Arrays;
import java.util.Collections;

/**
 * The Collections.reverseOrder() Comparator
 */
public class Reverse {
    public static void main(String[] args){
        CompType[] a = new CompType[10];
        Arrays2.fill(a, CompType.generator());
        System.out.println("before sorting, a = " + Arrays.asList(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("after sorting a = " + Arrays.asList(a));
    }
}
