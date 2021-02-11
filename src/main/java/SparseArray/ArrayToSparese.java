package SparseArray;

/**
 * @author Yue_
 * @create 2021-02-09-12:13
 */
public class ArrayToSparese {

    private static int row;
    private static int column;
    private static int effectiveNums = 0;  //有效数据个数

    public static int[][] arrayToSparese(int [][] array,int invalidNum){
        row = array.length;
        column = array[0].length;
        effectiveNums = getEffectiveNum(array,invalidNum);
        //创建稀疏数组
        int[][] newArray = new int[effectiveNums + 1][3];
        //填充第一行
        newArray[0][0] = row;
        newArray[0][1] = column;
        newArray[0][2] = effectiveNums;
        //填充剩余行
        int[][] spareseArrary = fillSparese(array, newArray,invalidNum);
        return spareseArrary;
    }

    //获取有效数据个数
    private static int getEffectiveNum(int [][] array,int invalidNum){
        for(int i = 0; i < row ; i++){
            for(int j = 0 ; j < column ; j++){
                if(array[i][j] != invalidNum){
                    effectiveNums += 1;
                }
            }
        }
        return effectiveNums;
    }

    //填充稀疏数组的剩余行
    private static int[][] fillSparese(int [][] array,int[][] newarray,int invalidNum){
        int effectiveNums = 0;
        for(int i = 0; i < row ; i++){
            for(int j = 0 ; j < column ; j++){
                if(array[i][j] != invalidNum){
                    effectiveNums ++;
                    newarray[effectiveNums][0] = i;
                    newarray[effectiveNums][1] = j;
                    newarray[effectiveNums][2] = array[i][j];
                }
            }
        }
        return newarray;
    }
}
