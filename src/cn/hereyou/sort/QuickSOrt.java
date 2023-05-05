package cn.hereyou.sort;

public class QuickSOrt {
    public static void QuickSort(int []arr,int low,int high) {
        if(low<high) {
            int pivotpos=partition(arr,low,high);
            QuickSort(arr,low,pivotpos-1);
            QuickSort(arr,pivotpos+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot=arr[low];
        while(low<high) {
            //起初，一定要从右边指针开始，因为arr[low]的值已经扔给了pivot，arr[low]
            //想象成无数字的空位
            while(low<high&&pivot<=arr[high]) {
                --high;
            }

            //把比pivot的小的数扔到左边指针
            //把arr[high]扔到arr[low]这个空位上
            //然后，high位置可以想象成无数字的空位
            arr[low]=arr[high];

            while(low<high&&arr[low]<=pivot) {
                ++low;
            }
            //把比pivot大的数扔到右边
            //把arr[low]扔到arr[high]这个空位上
            //然后，low位置可以想象成是无数字的空位
            arr[high]=arr[low];
        }
        //此时low==high,return high也一样
        arr[low]=pivot;
        return low;
    }

}
