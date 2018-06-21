package com.sigar.think.c11;

import java.util.Random;

/**
 * 从方法中返回数组
 */
public class IceCream {
    private static Random rand = new Random();

    /**
     * 不同的口味
     */
    public static final String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    public static String[] flavorSet(int n){
        String[] results = new String[n];
        boolean[] picked = new boolean[flavors.length];

        // 这段代码设计得比较巧妙
        // picked[]数组对应flavors数组，已经被取值过得，就标为true
        // 在while循环中如果遇到picked下标为true的就重新拿一个随机数
        // 这样就巧妙得避免了重复取到flavors数组中的值。
        for(int i=0; i<n; i++){
            int t;
            do {
                t = rand.nextInt(flavors.length);
            }while (picked[t]);
            results[i] = flavors[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args){
        for(int i=0; i<20; i++){
            System.out.println("flavorSet(" + i + ") = ");
            String[] fl = flavorSet(flavors.length);
            for (int j=0; j<fl.length; j++){
                System.out.println("\t " + fl[j]);
            }
        }
    }
}
