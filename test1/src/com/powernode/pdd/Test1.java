package com.powernode.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2025/9/28 19:01
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean isValid = true;
        if (s == null || s.length() != 9) {
            isValid = false;
        }

        if (isValid) {
            char[] chars = s.toCharArray();

            int index = 0;
            int sum = 0;

            for (; index < 2 && isValid; index++) {
                char ch = chars[index];
                if ('A' <= ch && ch <= 'Z') {
                    sum += ch;
                } else {
                    isValid = false;
                }
            }

            for (; index < 8 && isValid; index++) {
                char ch = chars[index];
                if ('0' <= ch && ch <= '9') {
                    sum += ch;
                } else {
                    isValid = false;
                }
            }

            sum = sum % 26 + 'A';
            if (isValid && sum != s.charAt(8)) {
                chars[8] = (char) sum;
            }
            if (isValid) {
                System.out.println(new String(chars));
            } else {
                System.out.println("Invalid");
            }
        } else {
            System.out.println("Invalid");
        }
    }
}
