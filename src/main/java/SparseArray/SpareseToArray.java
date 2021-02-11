package SparseArray;

/**
 * @author Yue_
 * @create 2021-02-09-12:14
 */
public class SpareseToArray {

    private static int row;
    private static int column;

    public static int[][] spareseToArrays(int [][] spareseArray){
        row = spareseArray[0][0];
        column = spareseArray[0][1];
        int[][] array = new int[row][column];
        int[][] ints = fillArrary(spareseArray, array);
        return ints;
    }

    public static int[][] fillArrary(int[][] spareseArray,int[][] array){
        int row = 0;
        int column = 0;
        int value = 0;
        for(int i = 1; i < spareseArray.length; i++){
            row = spareseArray[i][0];
            column = spareseArray[i][1];
            value = spareseArray[i][2];
            array[row][column] = value;
        }
        return array;
    }
}
