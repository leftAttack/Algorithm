package Sort;

/**
 * @author Yue_
 * @create 2021-02-11-16:48
 */
//选择排序
public class ChooseSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,9,3,4,7,11,6,32,1,23,5,221,86,72,889};
        ChooseSort chooseSort = new ChooseSort();
        int[] sort = chooseSort.sort(arr);
        for(int item:sort){
            System.out.print(item + "\t");
        }
    }

    public int[] sort(int[] arr){
        int min;
        int minIndex ;
        for(int i = 0;i < arr.length -1; i++){
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }
}
