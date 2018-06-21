package com.sigar.think.c11;

// A small mythical creature
// 一个虚构的生物
class Weeble{}

public class ArraySize {
    public static void main(String[] args){
        // 对象数组：
        Weeble[] a;     // Local uninitialized variable
        Weeble[] b = new Weeble[5]; // Null references
        Weeble[] c = new Weeble[4];

        for(int i=0; i<c.length; i++){
            if(c[i] == null){   // Can test null reference
                c[i] = new Weeble();
            }
        }

        // Aggregate initialization
        Weeble[] d = {
                new Weeble(), new Weeble(), new Weeble()
        };
        // Dynamic aggregate initialization
        a = new Weeble[]{
                new Weeble(), new Weeble()
        };

        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        // The references inside the array are

        // automatically initialized to null:
        for(int i=0; i<b.length; i++){
            System.out.println("b[" + i + "]=" + b[i]);
        }

        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);

        a = d;
        System.out.println("a.length = " + a.length);

        // 基本类型数组
        int[] e;   // Null reference
        int[] f = new int[5];
        int[] g = new int[4];
        for(int i=0; i<g.length; i++){
            g[i] = i*i;
        }
        int[] h = {11, 47, 93};

        // 编译错误：变量e没有被初始化
//         System.out.println("e.length:" + e.length);
        System.out.println("f.length = " + f.length);
        // The primitives inside the array are automatically initialized to zero（数组中的基本类型会被自动初始化为0）:
        for(int i=0; i<f.length; i++){
            System.out.println("f[" + i + "]=" + f[i]);
        }
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{ 1,2 };
        System.out.println("e.length = " + e.length);

    }
}
