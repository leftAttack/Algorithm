package Sort;

/**
 * @author Yue_
 * @create 2021-02-11-17:27
 */
//希尔排序
public class ShellSort {

    public static void main(String[] args) {
        int[] ints = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        ShellSort shellSort = new ShellSort();
        //int[] sort = shellSort.sort(ints);
        int[] sort = shellSort.sortGreet(ints);
        for (int item : sort) {
            System.out.print(item + "\t");
        }
    }

    //交换法
    public int[] sort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        return arr;
    }

    //位移法
    public int[] sortGreet(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertVal = arr[i];
                int insertIdx = i - gap;
                while (insertIdx >= 0 && insertVal < arr[insertIdx]){
                    arr[insertIdx + gap] = arr[insertIdx];
                    insertIdx -= gap;
                }
                insertIdx += gap;
                arr[insertIdx] = insertVal;
            }
        }
        return arr;
    }
}
