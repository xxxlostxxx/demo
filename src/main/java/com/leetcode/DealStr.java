package com.leetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author youzhu@dian.so
 * @version 1.0.0
 * @Date 2018-09-29
 * @Copyright 北京伊电园网络科技有限公司 2016-2018 © 版权所有 京ICP备17000101号
 */
public class DealStr {

    public static void main(String[] args) throws Exception {
        /*File file = new File("/Users/zl/Desktop/panpan.txt");
        InputStream in = null;
        in= new FileInputStream(file);
        int tempByte;
        while ((tempByte = in.read()) != -1){
            System.out.println(tempByte);
        }*/
        readFileByLines("/Users/zl/Desktop/panpan.txt");

    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                String trim = tempString.trim();
                if (!trim.equals("") ){
                    System.out.print(tempString);

                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

}
