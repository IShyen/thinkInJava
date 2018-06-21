package com.sigar.other.jay3.generic;

/**
 * 子类不明确泛型类的类型参数变量:
 *      子类也要定义出<T>类型
 *
 *      类上声明的泛形只对非静态成员有效（为什么？）
 */
public class InterImpl2<T> implements Inter<T>{
    @Override
    public void show(T t) {
        System.out.println(t);

    }

    public static void main(String[] args) {
        //测试第一种情况
        Inter<String> i = new InterImpl();
        i.show("hello");

        //第二种情况测试
        Inter<String> ii = new InterImpl2<>();
        ii.show("100");
    }
}
