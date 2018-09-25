package com.anno;

public class Demo1 {

    public Demo1() {
        new Demo2();
        System.out.println("demo1");
    }

    class Demo2{
        public Demo2() {
            System.out.println("demo2");
        }
    }

    public static void main(String[] args) {
        new Demo1();
    }
}
