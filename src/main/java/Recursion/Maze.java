package Recursion;

/**
 * @author Yue_
 * @create 2021-02-11-12:06
 */
public class Maze {

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.find(maze.map, 1,1);
    }

    private int[][] map;

    public Maze(){
        map = new int[8][7];
        mazeInitialization();
    }

    //小球找路方法
    public boolean find(int[][] map,int i,int j){
        if (map[6][5] == 2) { // 通路已经找到ok
            return true;
        } else {
            if (map[i][j] == 0) { // 如果当前这个点还没有走过
                // 按照策略 下->右->上->左 走
                map[i][j] = 2; // 假定该点是可以走通.
                if (find(map, i + 1, j)) {// 向下走
                    return true;
                } else if (find(map, i, j + 1)) { // 向右走
                    return true;
                } else if (find(map, i - 1, j)) { // 向上走
                    return true;
                } else if (find(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    // 说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1,2,3
                return false;
            }
        }
    }

    private void mazeInitialization(){
        //设置上下边界
        for(int i1 = 0;i1 <7;i1++){
            map[0][i1] = 1;
            map[7][i1] = 1;
        }
        //设置左右边界
        for(int i2 = 0; i2 < 8; i2++){
            map[i2][0] = 1;
            map[i2][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
    }
}
