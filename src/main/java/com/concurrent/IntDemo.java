package com.concurrent;

public class IntDemo {

    volatile   int a=0;

     private static IntDemo intDemo;

    public IntDemo() {
         a = 3;
        intDemo = this;
    }

    public static void writer(){
        new IntDemo();

    }

    public static void reader(){
        while (true){
            if (intDemo!=null){
                System.out.println(intDemo.a);
                break;
            }else {
                System.out.println("====");
            }
        }

    }

}
