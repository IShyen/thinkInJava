package com.sigar.think.c08;//: c08:Sequence.java
// Holds a sequence of Objects.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.sigar.think.bruceeckel.simpletest.*;

interface Selector {
  boolean end();
  Object current();
  void next();
}

public class Sequence {
  static Test monitor = new Test();
  private Object[] obs;
  private int next = 0;

  public Sequence(int size) {
    obs = new Object[size];
  }

  public void add(Object x) {
    if(next < obs.length) {
      obs[next] = x;
      next++;
    }
  }

  private class SSelector implements Selector {
    int i = 0;
    public boolean end() {
      return i == obs.length;
    }
    public Object current() {
      return obs[i];
    }
    public void next() {
      if(i < obs.length) i++;
    }
  }

  public Selector getSelector() {
    return new SSelector();
  }

  public static void main(String[] args) {
    Sequence s = new Sequence(10);
    for(int i = 0; i < 10; i++)
      s.add(Integer.toString(i));
    Selector sl = s.getSelector();    
    while(!sl.end()) {
      System.out.println(sl.current());
      sl.next();
    }
    monitor.expect(new String[] {
      "0",
      "1",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9"
    });
  }
} ///:~