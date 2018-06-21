package com.sigar.think.c11;

import java.util.Arrays;

/**
 * Using System.arraycopy()
 */
public class CopyingArrays {
    public static void main(String[] args){
        int[] i = new int[7];
        int[] j = new int[10];

        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + j);

        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);

        Arrays.fill(k, 103);
        System.arraycopy(k, 0,i,0,k.length);

        // Objects
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(10));
        Arrays.fill(v, new Integer(99));
        System.out.println("u = " + Arrays.asList(u));
        System.out.println("v = " + Arrays.asList(v));
        System.arraycopy(v, 0, u, u.length/2, v.length);
        System.out.println("u = " + Arrays.asList(u));
    }
}
