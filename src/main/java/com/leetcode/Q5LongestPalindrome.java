package com.leetcode;

import java.util.Arrays;

public class Q5LongestPalindrome {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is
     * 1000.
     *
     * Example 1:
     *
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
     *
     * Input: "cbbd"    || 思想 Output: "bb"
     */

    public static void main(String[] args) {
        Q5LongestPalindrome q = new Q5LongestPalindrome();
        String s = q.longestPalindrome("123455432");
        System.out.println("answer:"+s);
    }

    public String longestPalindrome(String s) {
        if (s == "") {
            return "";
        }
        int longest = 0;
        String longString = "";
        // 一个char数组 一次遍历 访问最长汇文  两个判断 i，i+1
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            int begin = i;
            int end = i;
            int length = 1;
            while (begin >= 0 && end < chars.length) {
                if (chars[begin] == chars[end]) {
                    length+=2;
                    begin--;
                    end++;
                }else {
                    break;
                }

            }
            if (length >longest) {
                longest= length;
                longString = String.valueOf(Arrays.copyOfRange(chars,begin+1,end));
            }


            int begin1 = i;
            int end1 = i+1;
            int length1 = 2;
            while (begin1 >= 0 && end1 < chars.length) {
                if (chars[begin1] == chars[end1]) {
                    length1+=2;
                    begin1--;
                    end1++;
                }else {
                    break;
                }

            }
            if (length1 >longest) {
                longest= length1;
                longString = String.valueOf(Arrays.copyOfRange(chars,begin1+1,end1));
            }

        }

        return longString;
    }



}
