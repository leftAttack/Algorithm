package Sort;

/**
 * @author Yue_
 * @create 2021-02-11-17:27
 */
//插入排序
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,9,3,4,7,11,6,32,1,23,5,221,86,72,889};
        InsertSort insertSort = new InsertSort();
        int[] sort = insertSort.sort(arr);
        for(int item:sort){
            System.out.print(item + "\t");
        }
    }

    public int[] sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = 0;j < i; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
