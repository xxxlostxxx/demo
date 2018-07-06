package com.lst.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Object pageData = new Object();
        PageData pageData1 = new PageData();
        PageData pageData2 = new PageData();
        PageData pageData3 = new PageData();
        PageData pageData4 = new PageData();
        PageData pageData5 = new PageData();

        list.add(pageData);
       /* list.add(pageData1);
        list.add(pageData2);
        list.add(pageData3);
        list.add(pageData4);
        list.add(pageData5);*/
        for (Object pageData6 : list){
            System.out.println( pageData6.toString());

        }
        list.stream().forEach(v -> {
            System.out.println(v.toString());
        });
     /*   list.stream().forEach(v ->{
            System.out.println(v.get("ddd"));
        });

*/

    }
}
