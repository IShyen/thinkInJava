//: c08:MultiImplementation.java
// With concrete or abstract classes, inner 
// classes are the only way to produce the effect
// of "multiple implementation inheritance."
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.c08;

//class C {}
abstract class D {}

class Z extends C {
  D makeD() { return new D() {}; }
} 

public class MultiImplementation {
  static void takesC(C c) {}
  static void takesD(D d) {}
  public static void main(String[] args) {
    Z z = new Z();
    takesC(z);
    takesD(z.makeD());
  }
} ///:~