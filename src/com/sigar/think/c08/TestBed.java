package com.sigar.think.c08;//: c08:TestBed.java
// Putting test code in a nested class.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class TestBed {
  TestBed() {}
  void f() { System.out.println("f()"); }

  public static class Tester {
    public static void main(String[] args) {
      TestBed t = new TestBed();
      t.f();
    }
  }
} ///:~