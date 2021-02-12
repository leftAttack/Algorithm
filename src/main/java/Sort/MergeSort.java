package Sort;

import java.util.Arrays;

/**
 * @author Yue_
 * @create 2021-02-11-22:46
 */
//归并排序
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] temp = new int[ints.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(ints,0,9,temp);
        System.out.println(Arrays.toString(ints));
    }

    //分
    public void sort(int[] arr,int low,int high,int[] temp){
        if(low < high){
            int mid = (low + high) / 2;
            sort(arr,low,mid,temp);
            sort(arr,mid + 1,high,temp);
            merge(arr,low,mid,high,temp);
        }
    }

    //治
    public void merge(int[] arr,int low,int mid,int high,int[] temp){
         int i = low; //合并时左边数组的第一个索引位置
         int j = mid + 1;  //合并时右边数组的第一个索引位置
         int t = 0; //指向temp数组的第一个索引位置

        //1.先将两个数组的其中一个全部放入temp
        while (i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }else{
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //2.将剩余数组的剩余元素转移到temp中
        while (i <= mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= high){
            temp[t] = arr[j];
            j++;
            t++;
        }
        //3.将temp中的元素移动回arr数组当中
        t = 0;
        int lowTemp = low;
        while (lowTemp <= high){
            arr[lowTemp] = temp[t];
            lowTemp++;
            t++;
        }
    }
}
