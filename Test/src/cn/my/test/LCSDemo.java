package cn.my.test;

import java.util.Arrays;
import java.util.Scanner;

public class LCSDemo {

    /**
     * 求两个字符串最大公共子序列
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        getLCS(s1,s2);

    }

    private static void getLCS(String string1, String string2) {
        char[] s1 = string1.toCharArray();
        char[] s2 = string2.toCharArray();

        //初始化矩阵
        //将第一行第一列初始化为0
        int[][] array = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i < s2.length + 1; i++) {
            array[0][i] = 0;
        }

        for (int i = 0; i < s1.length + 1; i++) {
            array[i][0] = 0;
        }


        //在每一行对应字符串角标的位置记录截止到该角标下已有的最长子序列数
        for (int i = 1; i < s1.length+1; i++) {
            for (int j = 1; j < s2.length+1; j++) {
                if (s1[i-1] == s2[j-1]) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }


        int i = s1.length;
        int j = s2.length;
        StringBuilder sb = new StringBuilder();

        while (i >= 1 && j >= 1) {
            if (s1[i-1] == s2[j-1]) {
                sb.append(s1[i - 1]);
                i--;
                j--;
            }else{
                if(array[i][j]>array[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        System.out.println(sb.reverse());



        for (int k = 0; k < array.length; k++) {
            System.out.println(Arrays.toString(array[k]));
        }

    }
}
