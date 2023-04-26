package cn.hereyou.sort;


/**
 * 归并排序将一个数组分成两个子数组，对每个子数组进行递归排序，然后将它们合并成一个有序数组。其时间复杂度为O(n*logn)，空间复杂度为O(n)。下面是一个Java实现示例：
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low;
        int j = mid+1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }


}
