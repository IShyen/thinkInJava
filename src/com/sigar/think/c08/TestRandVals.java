package com.sigar.think.c08;//: c08:TestRandVals.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.sigar.think.bruceeckel.simpletest.*;

public class TestRandVals {
  static Test monitor = new Test();
  public static void main(String[] args) {
    System.out.println(RandVals.rint);
    System.out.println(RandVals.rlong);
    System.out.println(RandVals.rfloat);
    System.out.println(RandVals.rdouble);
    monitor.expect(new Object[] {
      "%%\\d",
      "%%\\d",
      "%%\\d\\.\\d+(E-){0,1}\\d+",
      "%%\\d\\.\\d+(E-){0,1}\\d+"
    });
  }
} ///:~
