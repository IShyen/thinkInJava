package com.sigar.think.c09.exercises;

class ExceptionA extends Exception{}

class ClassA{
    public ClassA() throws ExceptionA{
        throw new ExceptionA();
    }
}

class ClassB extends ClassA{
//    public ClassB(){
//        try{
//            super();
//        }catch (ExceptionA e){
//            e.printStackTrace();
//        }
//    }

    /**
     * super()在第一行的原因就是: 子类有可能访问了父类对象,
     * 比如在构造函数中使用父类对象的成员函数和变量,
     * 在成员初始化使用了父类, 在代码块中使用了父类等,
     * 所以为保证在子类可以访问父类对象之前要完成对父类对象的初始化
     */
    public ClassB() throws ExceptionA{
        super();
    }
}

public class E11_ConstructorExceptions {
}
