package com.demo1.testdesign.adapter.objectadapter;

public class AdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.method1();
        adapter.method2();
    }
}
