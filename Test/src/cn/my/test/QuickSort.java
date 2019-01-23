package cn.my.test;

import java.util.Arrays;

public class QuickSort {
    /**
     * 快排练习
     */

    public static void main(String[] args) throws InterruptedException {

        int[] arr = {22,6,1,5,4,7,8,9,33,44,55,44,11,1,2,3,6,87,7,9};
        int[] arr1 = {22,6,1,5,4,7,8,9,33,44,55,44,11,1,2,3,6,87,7,9};
        int[] arr1212 = {1,1,1,1,1,1,1,1};

        System.out.println("before:" + Arrays.toString(arr));

        quickSort(arr1212, 0, arr1212.length - 1);

        System.out.println("after:" + Arrays.toString(arr1212));

        Arrays.sort(arr1212);
        System.out.println("real:" + Arrays.toString(arr1212));

    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int low, int high) throws InterruptedException {

        if (low < high) {

            int mid = partition(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }

    }

    /**
     *
     */
    public static int partition(int[] arr, int low, int high) throws InterruptedException {

        int temp = low;
        while (low < high) {
            if (arr[high] >= arr[temp]) {
                high--;
                continue;
            }
            if (arr[low] <= arr[temp]) {
                low++;
                continue;
            }
            swap(arr, low, high);
        }
        swap(arr, temp, low);
        return low;

    }

    public static void swap(int[] arr, int i, int j) {
        int t = 0;
        t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}


