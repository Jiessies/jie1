package com.demo1.testdesign.adapter.objectadapter;

public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void method1() {
        adaptee.method1();
    }

    @Override
    public void method2() {
        System.out.println("method 2");
    }
}
