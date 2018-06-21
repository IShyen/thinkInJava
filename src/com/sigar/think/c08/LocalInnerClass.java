package com.sigar.think.c08;//: c08:LocalInnerClass.java
// Holds a sequence of Objects.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.sigar.think.bruceeckel.simpletest.*;

interface Counter {
  int next();
}

public class LocalInnerClass {
  static Test monitor = new Test();
  private int count = 0;
  // A local inner class:
  Counter getCounter(final String name) {
    class LocalCounter implements Counter {
      public LocalCounter() {
        // Local inner class can have a constructor
      }
      public int next() { 
        System.out.print(name); // Access local final
        return count++; 
      }
    }
    return new LocalCounter();
  }
  // The same thing as an anonymous inner class:
  Counter getCounter2(final String name) {
    return new Counter() {
      // Anonymous inner class cannot have a constructor
      public int next() { 
        System.out.print(name); // Access local final
        return count++; 
      }
    };
  }

  public static void main(String[] args) {
    LocalInnerClass lic = new LocalInnerClass();
    Counter 
      c1 = lic.getCounter("Local inner "),
      c2 = lic.getCounter2("Anonymous inner ");
    for(int i = 0; i < 5; i++)
      System.out.println(c1.next());
    for(int i = 0; i < 5; i++)
      System.out.println(c2.next());
    monitor.expect(new String[] {
      "Local inner 0",
      "Local inner 1",
      "Local inner 2",
      "Local inner 3",
      "Local inner 4",
      "Anonymous inner 5",
      "Anonymous inner 6",
      "Anonymous inner 7",
      "Anonymous inner 8",
      "Anonymous inner 9"
    });
  }
} ///:~