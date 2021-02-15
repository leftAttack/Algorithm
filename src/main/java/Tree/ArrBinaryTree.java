package Tree;

/**
 * @author Yue_
 * @create 2021-02-13-10:16
 */
//以数组的方式顺序存储二叉树
public class ArrBinaryTree {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
        System.out.println();
        arrBinaryTree.infixOrder(0);
        System.out.println();
        arrBinaryTree.postOrder(0);
    }

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //前序遍历
    //index数组的下标
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        if(2 * index + 1 < arr.length){
            preOrder(2 * index + 1);
        }
        if(2 * index + 2 < arr.length){
            preOrder(2 * index + 2);
        }
    }

    //中序遍历
    //index数组的下标
    public void infixOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        if(2 * index + 1 < arr.length){
            infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if(2 * index + 2 < arr.length){
            infixOrder(2 * index + 2);
        }
    }

    //后序遍历
    //index数组的下标
    public void postOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        if(2 * index + 1 < arr.length){
            postOrder(2 * index + 1);
        }
        if(2 * index + 2 < arr.length){
            postOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
