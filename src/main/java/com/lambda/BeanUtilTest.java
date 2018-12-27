package com.lambda;


import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author youzhu@dian.so
 * @version 1.0.0
 * @Date 2018-09-04
 * @Copyright 北京伊电园网络科技有限公司 2016-2018 © 版权所有 京ICP备17000101号
 */
public class BeanUtilTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        DemoBean demoBean = new DemoBean();
        demoBean.setDemo1("123");
        demoBean.setDemo2("1234");
        demoBean.setDemo3("1235");
        demoBean.setDemo4("1236");
        demoBean.setDemo5("1237");
        demoBean.setDemo6("1238");
        demoBean.setDemo7("1239");



        Long begin =  System.currentTimeMillis();


            DemoBean2 demoBean2 = new DemoBean2();
            demoBean2.setDemo1(demoBean.getDemo1());
            demoBean2.setDemo2(demoBean.getDemo2());
            demoBean2.setDemo3(demoBean.getDemo3());
            demoBean2.setDemo4(demoBean.getDemo4());
            demoBean2.setDemo5(demoBean.getDemo5());
            demoBean2.setDemo6(demoBean.getDemo6());
            demoBean2.setDemo7(demoBean.getDemo7());

        Long end = System.currentTimeMillis();



        Long begin2 =System.currentTimeMillis();

        DemoBean2 demoBean21 = new DemoBean2();


        Long end2 =System.currentTimeMillis();

        long l = System.currentTimeMillis();
        long l1 = System.currentTimeMillis();
        System.gc();
        long l3 = System.currentTimeMillis();
        long l2 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println(l2-l3);
        System.out.println(end-begin);
        System.out.println(end2-begin2);
        Stream<Integer> stream = Arrays.asList(1, 2, 3).stream();
        Stream<Integer> integerStream = stream.filter(x -> x == 1);

        integerStream.forEach(v -> {
            System.out.println(v);
        });

    }

}
