package com.leetcode;

import java.util.Arrays;

/**
 * 傻逼
 *
 */
public class ReverseInteger {


    public static void main(String[] args) {

        ReverseInteger reverseInteger = new ReverseInteger();
        int reverse = reverseInteger.reverse(-321);
        System.out.println(reverse);
    }
    public int reverse(int x) {

        boolean flag =false ;
        int i = 0;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int j =chars.length;

        if (chars[0]=='-') {
            flag=true;
            j--;
        }
        char[] demo = new char[chars.length];


        for ( ; i<j ; i++) {
            demo[i + 1] = chars[chars.length - i - 1];
        }
        if (flag) {
            demo[0] = '-';
        } else {

        }

        return Integer.parseInt(String.valueOf(demo));
    }
}
