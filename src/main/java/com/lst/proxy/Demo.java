package com.lst.proxy;

import java.lang.reflect.*;

public class Demo {

    public interface IHello{
         void sayHello();
    }

    static class Hello implements  IHello{
        @Override
        public void sayHello() {
            System.out.println("say Hello");
        }
    }

    // 自定义InvocationHandler
    static class InvocationDemo implements InvocationHandler {
        private Object target;

        public InvocationDemo(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] args) throws Throwable {
            System.out.println("=====前置通知=======");
            Object invoke = method.invoke(target, args);
            System.out.println("=====前置通知=======");
            return invoke;
        }
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 生成$Proxy 的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        // 获取动态代理类
        Class<?> proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);

        //获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);

        // 通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        IHello iHello = (IHello)constructor.newInstance(new InvocationDemo(new Hello()));

        // 通过代理对象调用目标方法
        iHello.sayHello();



    }






}
