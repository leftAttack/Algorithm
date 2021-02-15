package CommonAlgorithm;

import java.util.Arrays;

/**
 * @author Yue_
 * @create 2021-02-15-14:55
 */
public class Bag {

    public static void main(String[] args) {
        int[][] goodsinfo = new int[][]{{1, 1500}, {4, 3000}, {3, 2000},{3,100000}};
        Bag bag = new Bag(4, goodsinfo);
        System.out.println("装入背包的最大价值为:" + bag.calculate());
    }

    private int bagSize;
    private int[][] goodsInfo;
    private int[][] bag;
    private int[][] path;//背包情况

    public Bag(int bagSize, int[][] goodsInfo) {
        this.bagSize = bagSize;
        this.goodsInfo = goodsInfo;
        bag = new int[goodsInfo.length + 1][bagSize + 1];
        path = new int[goodsInfo.length + 1][bagSize + 1];
    }

    public int calculate() {
        for (int i = 1; i < bag.length; i++) {
            for (int j = 1; j < bag[0].length; j++) {
                if (j >= goodsInfo[i - 1][0]) {
                    if (goodsInfo[i - 1][1] + bag[i - 1][j - goodsInfo[i - 1][0]] > bag[i - 1][j]) {
                        bag[i][j] = goodsInfo[i - 1][1] + bag[i - 1][j - goodsInfo[i - 1][0]];
                        path[i][j] = 1;
                    }else {
                        bag[i][j] = bag[i - 1][j];
                    }
                } else {
                    bag[i][j] = bag[i - 1][j];
                }
            }
        }
        printf(bag);
        printfGoods();
        return bag[goodsInfo.length][bagSize];
    }

    public void printfGoods(){
        int i = path.length -1; //行的最下标
        int j = path[0].length -1; //列的最下标
        while (i > 0 && j > 0){
            if(path[i][j] == 1){
                System.out.println("将物品" + i  + "装入背包");
                j -= goodsInfo[i -1][0];
            }
            i--;
        }
    }

    public void printf(int[][] bag) {
        for (int i = 0; i < bag.length; i++) {
            System.out.println(Arrays.toString(bag[i]));
        }
    }
}
