package Tree;

/**
 * @author Yue_
 * @create 2021-02-12-20:40
 */
public class HeroNode {

    private int No;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        No = no;
        this.name = name;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public HeroNode preFind(int i){
        System.out.println("前序查找");
        if(this.No == i){
            return this;
        }
        HeroNode res = null;
        if(this.left != null){
            res = this.left.preFind(i);
        }
        if(res != null){
            return res;
        }
        if(this.right != null){
            res = this.right.preFind(i);
        }
        return res;
    }

    //中序查找
    public HeroNode infixFind(int i){
        HeroNode res = null;
        if(this.left != null){
            res = this.left.infixFind(i);
        }
        if(res != null){
            return res;
        }
        System.out.println("中序查找");
        if(this.No == i){
            return this;
        }
        if(this.right != null){
            res = this.right.infixFind(i);
        }
        return res;
    }

    //后序查找
    public HeroNode postFind(int i){
        HeroNode res = null;
        if(this.left != null){
            res = this.left.postFind(i);
        }
        if(res != null){
            return res;
        }
        if(this.right != null){
            res = this.right.postFind(i);
        }
        if(res != null){
            return res;
        }
        System.out.println("后序查找");
        if(this.No == i){
            return this;
        }
        return res;
    }

    public boolean delete(int No){
        boolean flag = false;
        if(this.left != null && this.left.No == No){
            this.left = null;
            return true;
        }
        if(this.right != null && this.right.No == No){
            this.right = null;
            return true;
        }
        if(this.left != null) {
            flag = this.left.delete(No);
        }
        if(flag == true){
            return true;
        }
        if(this.right != null) {
            flag = this.right.delete(No);
        }
        return flag;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "No=" + No +
                ", name='" + name + '\'' +
                '}';
    }
}
