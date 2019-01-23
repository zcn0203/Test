package cn.my.test;

import java.util.Scanner;

public class ZuichangGonggong {
    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     */
    public static void mian(String[] args) {

        Scanner sc = new Scanner(System.in);



    }


    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        else if(strs.length == 1)
            return strs[0];

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int temp = 0;
        while(true){
            char ch = 0;
            for(int i = 0; i<strs.length; i++){

                if(strs[i].equals("") || strs[i] == null)
                    return sb.toString();

                if(count >= strs[i].length())
                    return sb.toString();
                if(temp == 0){
                    if(count < strs[i].length()){
                        ch = strs[i].charAt(count);
                        temp++;
                    }else{
                        return sb.toString();
                    }

                }else{
                    if(ch == strs[i].charAt(count)){
                        temp++;
                        if(temp == strs.length){
                            sb.append(ch);
                            temp = 0;
                            count++;
                            if(count > strs[i].length())
                                return sb.toString();
                            break;
                        }
                    } else {
                        return sb.toString();
                    }
                }
            }

        }


    }
}
