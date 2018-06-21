package com.sigar.think.c08;//: c08:Parcel2.java
// Returning a reference to an inner class.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.sigar.think.bruceeckel.simpletest.*;

public class Parcel2 {
  static Test monitor = new Test();

  class Contents {
    private int i = 11;
    public int value() { return i; }
  }

  class Destination {
    private String label;
    Destination(String whereTo) {
      label = whereTo;
    }
    String readLabel() { return label; }
  }

  public Destination to(String s) {
    return new Destination(s);
  }

  public Contents cont() { 
    return new Contents(); 
  }

  public void ship(String dest) {
    Contents c = cont();
    Destination d = to(dest);
    System.out.println(d.readLabel());
  }

  public static void main(String[] args) {
    Parcel2 p = new Parcel2();
    p.ship("Tanzania");
    Parcel2 q = new Parcel2();
    // Defining references to inner classes:
    Contents c = q.cont();
    Destination d = q.to("Borneo");
    monitor.expect(new String[] {
      "Tanzania"
    });
  }
} ///:~