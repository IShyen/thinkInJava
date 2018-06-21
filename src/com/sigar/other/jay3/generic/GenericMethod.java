package com.sigar.other.jay3.generic;

public class GenericMethod {
    public <T> void show(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        //创建对象
        GenericMethod tool = new GenericMethod();

        //调用方法,传入的参数是什么类型,返回值就是什么类型
        tool.show("hello");
        tool.show(12);
        tool.show(12.5);
    }
}
