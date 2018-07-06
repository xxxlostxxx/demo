package com.concurrent;

import com.alibaba.fastjson.JSONObject;

public class jucQueueDemo {
    static Object a  = new Object();

    public static void main(String[] args) {
        Object t=  a;
        Object x =t;
        ;
        System.out.println(x.toString());
        System.out.println(t.toString());
        ;

    }
}
