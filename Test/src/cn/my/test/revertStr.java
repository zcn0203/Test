package cn.my.test;

import java.util.Scanner;

public class revertStr {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */

    public static void mian(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = reverseWords(sc.nextLine());

        System.out.println(s);

    }

    public static String reverseWords(String s) {

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<strs.length; i++){
            char[] chars = strs[i].toCharArray();
            for(int j = 0; j<chars.length/2; j++){
                char temp = chars[j];
                chars[j] = chars[chars.length-1-j];
                chars[chars.length-1-j] = temp;
            }

            for(int k = 0; k<chars.length; k++){
                sb.append(chars[k]);
            }
            if(i!=strs.length-1)
                sb.append(" ");
        }

        return sb.toString();

    }
}
