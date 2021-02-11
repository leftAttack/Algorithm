package Recursion;

import java.util.ArrayList;

/**
 * @author Yue_
 * @create 2021-02-11-13:16
 */
public class EightQueen {

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.place(0);
        System.out.println("八皇后问题共有" + eightQueen.getCount() + "个解法");
    }

    private int max = 8;
    private int[] arr = new int[8];
    private int count;

    //放置第n个皇后
    public void place(int n){
        if(n == max){
            print();
            return;
        }
        for(int i = 0; i < max; i++){
            arr[n] = i;
            if(isConflict(n)){
                place(n + 1);
            }
        }
    }

    //判断是否冲突
    private boolean isConflict(int n){
       for(int i = 0; i < n; i++){
           //  判断是否在同一列             判断是否在同一条斜线
           if(arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
               return false;
           }
       }
       return true;
    }

    private void print(){
        for(int i : arr){
            System.out.print(i);
        }
        System.out.println();
        count ++;
    }

    public int getCount(){
        return count;
    }
}
