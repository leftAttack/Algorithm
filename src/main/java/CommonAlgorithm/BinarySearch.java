package CommonAlgorithm;

/**
 * @author Yue_
 * @create 2021-02-15-14:00
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("索引位置为" + binarySearch.binarySearch(arr, 4, 0, 3));
        System.out.println("索引位置为" + binarySearch.binarySearch(arr, 4));
    }

    //递归实现
    public int binarySearch(int[] arr,int target,int begin,int end){
        int mid = (begin + end)/2;
        if(target > arr[mid]){
            return binarySearch(arr,target,mid + 1,end);
        }else if(target < arr[mid]){
            return binarySearch(arr,target,begin,mid - 1);
        }else{
            return mid;
        }
    }

    //非递归实现
    public int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(target < arr[mid]){
                right = mid - 1;
            }else if(target > arr[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
