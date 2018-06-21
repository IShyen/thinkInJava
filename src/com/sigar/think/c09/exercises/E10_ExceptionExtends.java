package com.sigar.think.c09.exercises;

class BaseEx extends Exception{}
class SonEx extends BaseEx{}
class GrandsonEx extends SonEx{}

class BaseClass{
    public void f() throws BaseEx{
        throw new BaseEx();
    }
}

class SonClass extends BaseClass{
    @Override
    public void f() throws SonEx {
        throw new SonEx();
    }
}

class GrandSonClass extends SonClass{
    @Override
    public void f() throws GrandsonEx {
        throw new GrandsonEx();
    }
}

public class E10_ExceptionExtends {
    public static void main(String[] args){
        BaseClass cls = new GrandSonClass();
        try{
            cls.f();
        }catch (BaseEx e){
            e.printStackTrace();
        }
    }
}
