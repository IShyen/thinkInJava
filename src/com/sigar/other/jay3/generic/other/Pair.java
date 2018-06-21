package com.sigar.other.jay3.generic.other;

public class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }

    public static void printEmployeeBoddies(Pair<? extends Employee> pair) {
        System.out.println(pair.getFirst().getName() + ":" + pair.getSecond().getName());
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(String n, double s) {
        super(n, s);
    }
}
class President extends Manager {
    public President(String n, double s) {
        super(n, s);
    }
}
