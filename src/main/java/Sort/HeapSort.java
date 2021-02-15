package Sort;

import java.util.Arrays;

/**
 * @author Yue_
 * @create 2021-02-13-14:16
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] ints = {4,6,8,5,9,1,3,19,15,11};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    //将普通完全二叉树调为大顶堆结构
    //i:最后一个非叶子结点
    public void adjustBigHeap(int[] arr,int i,int length){
        int temp = arr[i];
        //将普通二叉树变成大顶堆
        for(int k = i * 2 + 1;k < length;k = 2 * k + 1){
            //如果左子树比右子树小
            if(k + 1 < length && arr[k] < arr[k+1]){
                k++;
            }
            //比较父节点与左子树或右子树大小
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        //for循环结束时 我们认为以i为父节点的树的最大值,放在了顶部
        arr[i] = temp;  //将temp放到调整后的位置
    }

    public void sort(int[] arr){
        int temp;
        //构造初始堆。将给定无序序列构造成一个大顶堆
        for(int i = arr.length/2 -1;i >= 0;i--){
            adjustBigHeap(arr,i,arr.length);
        }
        //将堆顶元素与末尾元素进行交换，使末尾元素最大。
        //然后继续调整堆，再将堆顶元素与末尾元素交换，得到第二大元素。如此反复进行交换、重建、交换
        for(int j = arr.length -1;j > 0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustBigHeap(arr,0,j);
        }
    }
}
