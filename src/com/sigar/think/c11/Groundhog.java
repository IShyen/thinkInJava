package com.sigar.think.c11;

/**
 * 土拨鼠
 * Looks plausible, but does't work as a HashMap key.
 */
public class Groundhog {
    protected int number;
    public Groundhog(int n){
        number = n;
    }

    public String toString(){
        return "Groundhog #" + number;
    }
}
