//: com:bruceeckel:simpletest:SimpleTestException.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.bruceeckel.simpletest;

public class SimpleTestException extends RuntimeException {
  public SimpleTestException(String cname, String msg) {
    super("Error testing output of class " + cname
      + ": " + msg);
  }
} ///:~
