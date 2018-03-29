package com.lst.controller;

import java.io.Serializable;

public class OverLoad {


    // no.1
    public static void sayHello(char arg){
        System.out.println("Hello char");
    }


    /**
     * no.2  char -> int -> long -> float -> double
     * @param arg
     */
    public static void sayHello(int arg){
        System.out.println("Hello int");
    }
    public  void sayHello1(int arg){
        System.out.println("Hello int");
    }
    public static void sayHello(Integer arg){
        System.out.println("Hello int");
    }


    // no.3
    public static void sayHello(long arg){
        System.out.println("Hello long");
    }

    // no.4
    public static void sayHello(Character arg){
        System.out.println("Hello Character");
    }


    // no.5
    public static void sayHello(Serializable arg){
        System.out.println("Hello Serializable");
    }
    // no.6
    public static void sayHello(Object arg){
        System.out.println("Hello Object");
    }
    // no.7
    public static void sayHello(char... arg){
        System.out.println("Hello char...");
    }




    public static void main(String[] args) {
        sayHello('a');
    }



}
