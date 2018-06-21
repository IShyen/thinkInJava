package com.sigar.think.c11;

import java.util.Arrays;

/**
 * using Arrays.fill()
 */
public class FillingArrays {
    public static void main(String[] args){
        int size = 6;

        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];
        String[] a9 = new String[size];

        Arrays.fill(a1,true);
        Arrays.fill(a2,(byte)11);
        Arrays.fill(a3, 'x');
        Arrays.fill(a4,(short)17);
        Arrays.fill(a5, 19);
        Arrays.fill(a6, 23);
        Arrays.fill(a7, 29);
        Arrays.fill(a8, 47);
        Arrays.fill(a9, "Hello");

        // Manipulating ranges:
        Arrays.fill(a9, 3, 5, "world");
        System.out.println("finish.");
    }
}
