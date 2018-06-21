//: com:bruceeckel:tools:Assert.java
// Turning off the assertion output 
// so you can ship the program.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.bruceeckel.tools;

public class Assert {
  public final static void is_true(boolean exp){}
  public final static void is_false(boolean exp){}
  public final static void 
  is_true(boolean exp, String msg) {}
  public final static void 
  is_false(boolean exp, String msg) {}
} ///:~