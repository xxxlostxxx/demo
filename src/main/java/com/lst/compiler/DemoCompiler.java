package com.lst.compiler;

import javax.tools.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.util.Arrays;

import static java.lang.System.out;

public class DemoCompiler {

      public static void demoCompiler(){
          JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
          // 建立DiagnosticCollector对象
          DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
          StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
          String source = "public class TestMain { " +
                  "public static void main(String[] args) " +
                  "{System.out.println(\"Hello World!\");} }";

          // 建立用于保存被编译文件名的对象
          // 每个文件被保存在一个从JavaFileObject继承的类中
          JavaSourceFromString sourceObject=new JavaSourceFromString("TestMain", source);
          Iterable<? extends JavaFileObject> fileObject=Arrays.asList(sourceObject);

          Iterable<String> options = Arrays.asList("-d", System.getProperty("user.dir")+"/bin");
          JavaCompiler.CompilationTask task = compiler.getTask(new PrintWriter(System.out), fileManager,
                  null, options, null, fileObject);
          // bianyi
          boolean success = task.call();
          try {
              fileManager.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
          out.println((success)?"编译成功":"编译失败");

      }
    static class JavaSourceFromString extends SimpleJavaFileObject {
        String code;
        JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/')+ Kind.SOURCE.extension), Kind.SOURCE);
            out.println(URI.create("string:///" + name.replace('.', '/')+ Kind.SOURCE.extension));
            out.println(Kind.SOURCE);
            this.code = code;
        }
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            out.println(code);
            return code;
        }
    }

    public static void main(String[] args) {
        demoCompiler();
    }

}
