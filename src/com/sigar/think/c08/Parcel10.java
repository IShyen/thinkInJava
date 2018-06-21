package com.sigar.think.c08;//: c08:Parcel10.java
// Nested classes (static inner classes).
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class Parcel10 {
  private static class PContents implements Contents {
    private int i = 11;
    public int value() { return i; }
  }

  protected static class PDestination implements Destination {
    private String label;
    private PDestination(String whereTo) {
      label = whereTo;
    }
    public String readLabel() { return label; }
    // Nested classes can contain 
    // other static elements:
    public static void f() {}
    static int x = 10;
    static class AnotherLevel {
      public static void f() {}
      static int x = 10;
    }
  }

  public static Destination dest(String s) {
    return new PDestination(s);
  }

  public static Contents cont() {
    return new PContents();
  }

  public static void main(String[] args) {
    Contents c = cont();
    Destination d = dest("Tanzania");
  }
} ///:~