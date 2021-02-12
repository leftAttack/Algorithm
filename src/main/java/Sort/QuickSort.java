package Sort;

import java.util.Arrays;

/**
 * @author Yue_
 * @create 2021-02-11-21:00
 */
//快速排序
public class QuickSort {

    public static void main(String[] args) {
        int[] ints = {1,3,5};
        QuickSort quickSort = new QuickSort();
        QuickSort.quickSort(ints, 0, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static void quickSort(int[] arr,int low,int high){

        //基准条件:数组中只剩下一个数或者数组为空时
        if(low>high){
            return;
        }

        int i,j,privot,temp;
        i=low;
        j=high;
        //privot就是基准数  arr[low]是基准位
        privot = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (privot<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (privot>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //最后将基准位与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = privot;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}
