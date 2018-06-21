//: com:bruceeckel:simpletest:NumOfLinesException.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package com.sigar.think.bruceeckel.simpletest;

public class NumOfLinesException 
  extends SimpleTestException {
  public NumOfLinesException(String className, 
    int exp, int out) {
      super(className, "num of lines of output and " 
        + "expected output did not match expected: <" + exp
        + "> lines  output: <" + out + "> lines)");
  }
} ///:~