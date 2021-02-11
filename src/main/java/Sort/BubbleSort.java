package Sort;


/**
 * @author Yue_
 * @create 2021-02-11-16:16
 */
//冒泡排序
public class BubbleSort {

    private int count; //遍历数组的次数

    public static void main(String[] args) {
        int [] arr = new int[]{3,9,-1,10,20};
        BubbleSort bubbleSort = new BubbleSort();
        //int[] sort = bubbleSort.sort(arr);
        int[] sort = bubbleSort.sortGreet(arr);
        for(int item: sort){
            System.out.print(item + "\t");
        }
        System.out.println("\n优化后遍历数组的次数为:" + bubbleSort.count + "次");
    }

    //从小到大排序
    public int[] sort(int[] arr){
        for(int i = 0;i < arr.length-1; i ++){
            for(int j = 0;j <arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    //优化版从小到大
    public int[] sortGreet(int[] arr){
        boolean flag;
        for(int i = 0;i < arr.length-1; i ++){
            count++;
            flag = true;
            for(int j = 0;j <arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if(flag == true){
                return arr;
            }
        }
        return arr;
    }
}
