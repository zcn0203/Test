package cn.my.test;

import java.util.Scanner;

public class HuiwenDemo {
    /**
     * 输出最长回文子串
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getHuiwen(sc.nextLine());

    }

    private static void getHuiwen(String s){

        int left = 0;
        int right = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int maxLength = 0;

        //分两种情况判断 1.奇数回文 2.偶数回文
        for (int i = 1; i < s.length() - 1; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left > maxLength) {
                        maxLeft = left;
                        maxRight = right;
                        maxLength = right - left;
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            left = i;
            right = i + 1;
            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left > maxLength) {
                        maxLeft = left;
                        maxRight = right;
                        maxLength = right - left;
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }

        System.out.println(s.substring(maxLeft, maxRight+1));

    }
}
