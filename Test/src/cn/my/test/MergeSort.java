package cn.my.test;

import java.util.Arrays;

public class MergeSort {
    /**
     * 归并排序
     */
    public static void main(String[] args) {

        int[] arr = {1, 5, 4, 7, 8, 9, 25, 87, 4, 1, 0, -20, 33, 66, 55, 88, 1111, 2222, 1212, 55, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        //新建固定长度数组
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);

    }

    private static void sort(int[] arr, int left, int right, int[] temp){

        if (left < right) {
            int mid = (left + right) >> 1;
            //左边归并排序，使得左半部分有序
            sort(arr, left, mid, temp);
            //右边归并排序，使得右半部分有序
            sort(arr, mid + 1, right, temp);
            //merge
            merge(arr, left, mid, right, temp);

        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        //从大到小放到临时数组
        while (i <= mid && j <= right) {
            if(arr[i]<=arr[j])
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[j++];
        }

        //将左边剩余元素放到临时数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        //将右边剩余元素放到临时数组
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;

        //复制临时数组
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
