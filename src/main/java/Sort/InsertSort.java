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
        //int[] sort = insertSort.sort(arr);
        int[] sort = insertSort.sortGreet(arr);
        for(int item:sort){
            System.out.print(item + "\t");
        }
    }

    //交换
    public int[] sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i;j > 0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    //移位
    public int[] sortGreet(int[] arr){
       for(int i = 1;i < arr.length;i ++){
           int insertVal = arr[i];
           int insertIdx = i -1; //要插入前面的那个数
           while (insertIdx >= 0 && insertVal < arr[insertIdx]){
               arr[insertIdx + 1] = arr[insertIdx];
               insertIdx --;
           }
           insertIdx ++;
           arr[insertIdx] = insertVal;
       }
       return arr;
    }
}
