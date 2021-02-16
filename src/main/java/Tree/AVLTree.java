package Tree;

/**
 * @author Yue_
 * @create 2021-02-14-21:22
 */
public class AVLTree {

    public static void main(String[] args) {
        Node root = new Node(2);
        AVLTree avlTree = new AVLTree(root);
        avlTree.add(new Node(1));
        avlTree.add(new Node(6));
        avlTree.add(new Node(5));
        avlTree.add(new Node(7));
        avlTree.add(new Node(3));
        avlTree.infixOrder();
        System.out.println();
        System.out.println(avlTree.root.height());
        System.out.println(avlTree.root.leftHeight());
        System.out.println(avlTree.root.rightHeight());
        System.out.println();
        avlTree.root.doubleRevolve();
        System.out.println(avlTree.root.height());
        System.out.println(avlTree.root.leftHeight());
        System.out.println(avlTree.root.rightHeight());
    }

    public Node root;
    private Node left;
    private Node right;

    public AVLTree(Node root) {
        this.root = root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("本树为空");
            return;
        }
        root.infixOrder();
    }
}

