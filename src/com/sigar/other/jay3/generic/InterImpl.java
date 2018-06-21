package com.sigar.other.jay3.generic;

/**
 * 子类明确泛型类的类型参数变量:
 */
public class InterImpl implements Inter<String>{
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
