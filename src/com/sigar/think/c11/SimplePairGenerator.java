package com.sigar.think.c11;

import com.sigar.think.bruceeckel.util.MapGenerator;
import com.sigar.think.bruceeckel.util.Pair;

public class SimplePairGenerator implements MapGenerator {
    public Pair[] items = {
      new Pair("one","A"), new Pair("two","B"), new Pair("Three","C"),
            new Pair("four","D"),new Pair("five","E"),new Pair("six","F"),
            new Pair("seven","G"),new Pair("eight","H"),new Pair("nine","I"),new Pair("ten","J")
    };

    private int index = -1;
    public Pair next(){
        index = (index+1)% items.length;
        return items[index];
    }

    public static SimplePairGenerator gen = new SimplePairGenerator();
}
