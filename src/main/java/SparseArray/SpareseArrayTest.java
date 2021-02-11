package SparseArray;

import org.junit.Test;

/**
 * @author Yue_
 * @create 2021-02-09-12:14
 */
public class SpareseArrayTest {

    @Test
    public void ArrayToSpareseTest(){
        System.out.println("**************二维数组转稀疏数组**************");
        int[][] checkerBoard = new int[11][11]; //五子棋盘
        checkerBoard[1][2] = 1;
        checkerBoard[2][3] = 2;
        checkerBoard[3][4] = 2;
        int[][] spareseArrays = ArrayToSparese.arrayToSparese(checkerBoard, 0);
        for(int[] array: spareseArrays){
            for (int item : array){
                System.out.print(item + "\t");
            }
            System.out.println();
        }
        System.out.println("**************稀疏数组转二维数组**************");

        int[][] array = SpareseToArray.spareseToArrays(spareseArrays);
        for(int[] arrayone: array){
            for (int item : arrayone){
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }
}
