package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.Arrays2;

import java.util.Arrays;

public class TestArray2 {
    public static void main(String[] args){
        int size = 6;
        // Or get the size from the command lines:
        // ...
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];

        Arrays2.fill(a1, new Arrays2.RandBooleanGenerator());
        Arrays2.fill(a2, new Arrays2.RandByteGenerator());
        Arrays2.fill(a3, new Arrays2.RandCharGenerator());
        Arrays2.fill(a4, new Arrays2.RandShortGenerator());
        Arrays2.fill(a5, new Arrays2.RandIntGenerator());
        Arrays2.fill(a6, new Arrays2.RandLongGenerator());
        Arrays2.fill(a7, new Arrays2.RandFloatGenerator());
        Arrays2.fill(a8, new Arrays2.RandDoubleGenerator());

//        System.out.println("a8 = " + Arrays2.);
    }
}
