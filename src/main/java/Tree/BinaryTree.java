package Tree;

/**
 * @author Yue_
 * @create 2021-02-12-20:40
 */
public class BinaryTree {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode 吴用 = new HeroNode(2, "吴用");
        HeroNode 卢俊义 = new HeroNode(3, "卢俊义");
        HeroNode 林冲 = new HeroNode(4, "林冲");
        HeroNode 关胜 = new HeroNode(5, "关胜");
        root.setLeft(吴用);
        root.setRight(卢俊义);
        卢俊义.setLeft(关胜);
        卢俊义.setRight(林冲);
        BinaryTree binaryTree = new BinaryTree(root);
        //前序遍历
        binaryTree.preOrder();//1 2 3 5 4
        //中序遍历
        binaryTree.infixOrder();//2 1 5 3 4
        //后序遍历
        binaryTree.postOrder(); //2 5 4 3 1
        //前序查找
        System.out.println(binaryTree.preFind(5));
        //中序查找
        System.out.println(binaryTree.infixFind(5));
        //后序查找
        System.out.println(binaryTree.postFind(5));
        System.out.println();
        System.out.println(binaryTree.delete(2));
        binaryTree.preOrder();//1 2 3 5 4
    }

    private HeroNode root;
    private HeroNode left;
    private HeroNode right;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder(){
        if(root != null){
            this.root.preOrder();
            System.out.println();
        }else {
            System.out.println("当前二叉树为空");
        }
    }

    //中序遍历
    public void infixOrder(){
        if(root != null){
            this.root.infixOrder();
            System.out.println();
        }else {
            System.out.println("当前二叉树为空");
        }
    }

    //后序遍历
    public void postOrder(){
        if(root != null){
            this.root.postOrder();
            System.out.println();
        }else {
            System.out.println("当前二叉树为空");
        }
    }

    //前序查找
    public HeroNode preFind(int i ){
        if(root != null){
            return root.preFind(i);
        }else{
            System.out.println("当前二叉树为空");
            return null;
        }
    }

    //中序查找
    public HeroNode infixFind(int i ){
        if(root != null){
            return root.infixFind(i);
        }else{
            System.out.println("当前二叉树为空");
            return null;
        }
    }

    //后序查找
    public HeroNode postFind(int i){
        if(root != null){
            return root.postFind(i);
        }else{
            System.out.println("当前二叉树为空");
            return null;
        }
    }

    public boolean delete(int No){
        if(root != null){
            if(No == root.getNo()){
                root = null;
            }else{
                return root.delete(No);
            }
        }
        return false;
    }
}
