package cn.hereyou.sort;


import java.util.Arrays;

/**
 *  [912]. 排序数组
 *  冒泡排序法
 */
public class SortArray {

    public static void main(String[] args) {
        int[] arr=sortArrar(new int[] {23,12,43,1,21,342,3,1,12});
        System.out.println(Arrays.toString(arr));
    }
    public static   int[] sortArrar(int [] arr){

        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int  temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;

    }



}
