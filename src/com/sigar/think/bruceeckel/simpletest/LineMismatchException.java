//: com:bruceeckel:simpletest:LineMismatchException.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.bruceeckel.simpletest;
import java.io.PrintStream;

public class LineMismatchException
  extends SimpleTestException {
  public LineMismatchException(String className, 
   int lineNum, String expected, String output) {
    super(className, "line " + lineNum 
      + " of output did not match " + "expected output"
      + " expected: <" + expected + ">" + " output: <" 
      + output + ">");
  }
} ///:~