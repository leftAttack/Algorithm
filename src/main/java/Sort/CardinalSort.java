package Sort;

import java.util.Arrays;

/**
 * @author Yue_
 * @create 2021-02-11-22:46
 */
//基数排序
public class CardinalSort {

    public static void main(String[] args) {
        int[] ints = {5521,123,8, 9, 1, 74, 22, 3, 5, 42, 6, 0,64};
        CardinalSort cardinalSort = new CardinalSort();
        cardinalSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void sort(int[] arr) {
        //定义一个二维数组,表示十个桶,每一个桶就是一个一维数组
        //为了防止在放入数的时候,数据溢出,则每一个桶大小都定为arr.length
        //因此基数排序是一种典序的空间换时间的算法
        int[][] bucket = new int[10][arr.length]; //桶

        //记录每个桶中放了多少个数据
        int[] buckerElementCounts = new int[10];

        //获取待排序的数组中最大的数
        int max = 0;
        for (int k = 0; k < arr.length; k++) {
            if (max < arr[k]) {
                max = arr[k];
            }
        }
        //获取最大的数的位数
        int length = (max + "").length();
        //进行排序
        for (int h = 0,n = 1; h < length; h++,n*=10) {
            for (int i = 0; i < arr.length; i++) {
                int geWei = arr[i] / n % 10;
                bucket[geWei][buckerElementCounts[geWei]] = arr[i];
                buckerElementCounts[geWei]++;
            }
            //取出桶中的值重新放回数组中
            //记录该放第几个元素
            int count = 0;
            for (int j = 0; j < bucket.length; j++) {
                int index = 0;
                while (!(buckerElementCounts[j] == 0)) {
                    arr[count] = bucket[j][index];
                    buckerElementCounts[j]--;
                    count++;
                    index++;
                }
            }
        }
    }
}
