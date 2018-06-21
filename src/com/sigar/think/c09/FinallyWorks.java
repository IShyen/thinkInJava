package com.sigar.think.c09;

/**
 * The finally clause is always executed.
 */
class ThreeException extends Exception{}

public class FinallyWorks {
    static int count = 0;

    /**
     * 这个程序也给了我们一些思路：当java中的异常不允许我们回到程序的起点时，
     * 可以把try块放在循环里，就建立了一个“程序继续执行之前必须要达到”的条件。
     * 还可以加入一个static类型的计数器或者别的装置，使循环在放弃以前能尝试一定的次数。
     * 这样的设计可以使程序的健壮性更上一个台阶。                -- Think in java 第三版 P_252
     */
    public static void main(String[] args){
        while (true){
            try{
                // Post-increment is zero first time:
                if(count++ == 0){
                    throw new ThreeException();
                }
                System.out.println("No exception");
            }catch (ThreeException e){
                System.err.println("ThreeException");
            }finally {
                System.err.println("In finally clause");
                if(count == 2){
                    break;
                }
            }
        }
    }
}
