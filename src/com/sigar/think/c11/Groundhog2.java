package com.sigar.think.c11;

/**
 * 土拨鼠
 * A class that's used as a key in a Hashmap must override hashCode() and equals()
 */
public class Groundhog2 extends Groundhog{
    public Groundhog2(int n){
        super(n);
    }

    public int hashCode(){
        return number;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Groundhog2) && (number == ((Groundhog2)o).number);
    }
}
