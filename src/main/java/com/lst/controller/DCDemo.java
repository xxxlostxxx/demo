package com.lst.controller;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 动态编译
 */
public class DCDemo {
    public DCDemo(){

    }
/*动态编译
   1. 读取String 生成java 文件
   2. java 文件 编译成 class
   3. classLoader 加载class
   4. 反射调用方法*/
    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(System.getProperty("user.dir"));//当前工作目录
        try {
           // LoadJar.loadJar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DCDemo javacTest = new DCDemo();
        DCDemo.eval("input_str");


    }

    public static String eval(String str){
        System.out.println(System.getProperty("user.dir"));//当前工作目录
        String s = "import com.lst.controller.OverLoad;\n public class Temp{" ;
        s+="\r\n"+"      public static String call(String ss){      ";
        s+="\r\n"+"            System.out.println(\""+str+"\");  ";
        s+="\r\n"+"            OverLoad overload = new OverLoad();  ";
        s+="\r\n"+"            overload.sayHello1(1);  ";
        s+="\r\n"+"            return \"return_str\"; ";
        s+="\r\n"+"      }";
        s+="\r\n"+"}";
        try{
            File file = new File("Temp.java");
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pw.println(s);
        //    pw.write(s);
            pw.close();

            //动态编译
            JavaCompiler javac = ToolProvider.getSystemJavaCompiler();

            int status = javac.run(null, null, null, "-d",System.getProperty("user.dir")+"\\bin","Temp.java");
            //javac.getTask(null,null,null,null,null,null);
            if(status!=0){
                System.out.println("没有编译成功！");
            }

            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();

           // classLoader.loadClass("Temp");

            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

            // This URL for a directory will be searched *recursively*
            URL classes;
            try {
                classes = new URL("file:///" + System.getProperty("user.dir") + "/bin/");

                ClassLoader custom =
                        new URLClassLoader(new URL[]{classes}, systemClassLoader);

                // this class should be loaded from your directory
                Class<?> clazz = custom.loadClass("Temp");

                Method[] methods = clazz.getDeclaredMethods();
                Method method = clazz.getDeclaredMethod("call", String.class);//返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法
                String result= (String)method.invoke(null, str);//静态方法第一个参数可为null,第二个参数为实际传参
                return result;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("dwq");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
          return "";
    }
}
