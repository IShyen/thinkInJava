package com.sigar.think.c09;

/**
 * Overridden methods may throw only the exception
 * specified in their base-class versions, or exceptions
 * derived from the base-class exceptions.
 */
class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}
class StrikeSon extends Strike{}

abstract class Inning{
    public Inning() throws BaseballException{}

    public void event() throws BaseballException{
        // Doesn't actually have to throw anything
    }

    public abstract void atBat() throws Strike, Foul;

    // Throws no checked exceptions
    public void walk(){}
}

class StormException extends Exception{}
class RainedOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
    // 子类构造器允许抛出新的异常，但它必须处理父类异常
    public StormyInning() throws RainedOut, BaseballException{}
    public StormyInning(String s) throws Foul, BaseballException{}

    // Regular methods must conform to base class:
    // 子类重写父类的方法，不能抛出父类方法没有抛出的异常：
//    public void walk() throws PopFoul{}     // compile error

    // Interface CANNOT add exceptions to existing methods from the base class:
//    public void event() throws RainedOut{}
    // If the method does't already exist in the base class, the exception is OK:
    public void rainHard() throws RainedOut{}

    // You can choose to not throw any exceptions, even if the base version does:
    // 父类方法抛出异常，子类重写的方法可以不抛出异常
    public void event(){}

    // Overridden methods can throw inherited exceptions:
    // 子类重写父类的方法，可以抛出父类方法异常的继承异常，可以不抛出父类方法抛出的异常：
    public void atBat() throws PopFoul{}

    public static void main(String[] args){
        try{
            StormyInning si = new StormyInning();
            si.atBat();
        }catch (PopFoul e){
            System.err.println("Pop foul");
        }catch (RainedOut e){
            System.err.println("Rained out");
        }catch (BaseballException e){
            System.err.println("Generic baseball exception");
        }

        // Strike not thrown in derived version.
        try{
            // What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            // You must catch the exceptions from the base-class version of the method:
        }catch (Strike e){
            System.err.println("Strike");
        }catch (Foul e){
            System.err.println("Foul");
        }catch (RainedOut e){
            System.err.println("Rained out");
        }catch (BaseballException e){
            System.err.println("Generic baseball exception");
        }
    }
}
