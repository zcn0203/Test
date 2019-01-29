package cn.my.test;

import java.util.ArrayList;

public class ShumeiTest {

    public static void main(String[] args) {

        //1.

        //int i = binary_to_integer("010110");

        //System.out.println(i);

        //2.
        /*ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(1);
        array1.add(3);
        array1.add(4);
        array1.add(5);
        array1.add(6);
        list.add(array1);
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(2);
        array2.add(7);
        array2.add(8);
        array2.add(10);
        array2.add(11);
        list.add(array2);
        ArrayList<Integer> array3 = new ArrayList<>();
        array3.add(5);
        array3.add(8);
        array3.add(9);
        array3.add(10);
        array3.add(13);
        list.add(array3);

        ArrayList<Integer> merge = merge(list);
        System.out.println(merge);
*/
        int [] a = {73	,88,	90,	4,	7	,9	,10,	24,	25,35,	65};

        int search = search(a, 35);
        System.out.println(search);


    }
    /**
     * 1.请将表示二进制整数的字符串“010110”转换成10进制整数。(如果你知道“二进制”的补码表示方式，请不要使用补码形式，这里的二进制是正常编码的二进制数)。
     * 不能使用已经存在的parseInteger()等库函数。算法复杂度O(n)
     */
    public static int binary_to_integer(String binary) {

        int high = 0;
        int sum = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {

            char ch = binary.charAt(i);
            int num = Integer.parseInt(ch + "");
            sum = (int) (sum + num*Math.pow(2,(double)high++));


        }



        return sum;

    }

    /**
     * 2.给定m个有序（递增）序列， 这些序列中包含的总的元素数目为n, 请将这些数组元素合并为一个有序（递增）序列。算法复杂度O(nm)
     */

    public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> seqs) {
        ArrayList<Integer> list = new ArrayList<>(0);



        for (int i = 0; i < seqs.size(); i++) {
            ArrayList<Integer> tempList = new ArrayList<>(0);
            int j = 0;
            int count = 0;

            while (j < seqs.get(i).size() && count < list.size()) {
                if (seqs.get(i).get(j) < list.get(count)) {
                    tempList.add(seqs.get(i).get(j));
                    j++;
                } else if (seqs.get(i).get(j) > list.get(count)) {
                    tempList.add(list.get(count));
                    count++;
                } else {
                    tempList.add(seqs.get(i).get(j));
                    tempList.add(list.get(count));
                    j++;
                    count++;
                }
            }

            while (j < seqs.get(i).size()) {
                tempList.add(seqs.get(i).get(j));
                j++;
            }

            while (count < list.size()) {
                tempList.add(list.get(count));
                count++;
            }
            System.out.println(tempList);

            list = tempList;

        }


        return list;
    }

    public static int search(int[] a, int x) {
        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
            if (a[i] < a[i + 1]) {
                continue;
            } else {
                temp = i+1;
                break;
            }
        }

        int left = temp;
        int right = a.length;

        int mid = (left + right) >> 1;
        while (left<right) {

            if (x<a[mid]) {
                right = mid;
                mid = (left + right) >> 1;
            } else if (x > a[mid]) {
                left = mid;
                mid = (left + right) >> 1;
            } else {
                return mid;
            }

        }

        return -1;

    }
}

