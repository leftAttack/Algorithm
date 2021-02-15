package Tree;

/**
 * @author Yue_
 * @create 2021-02-14-10:38
 */
public class BinarySortTree {

    public static void main(String[] args) {
        Node root = new Node(7);
        BinarySortTree binarySortTree = new BinarySortTree(root);
        binarySortTree.add(new Node(3));
        binarySortTree.add(new Node(10));
        binarySortTree.add(new Node(12));
        binarySortTree.add(new Node(5));
        binarySortTree.add(new Node(1));
        binarySortTree.add(new Node(9));
        binarySortTree.add(new Node(2));
        binarySortTree.infixOrder();
        binarySortTree.delete(7);
        binarySortTree.delete(3);
        binarySortTree.delete(1);
        binarySortTree.delete(10);
        binarySortTree.delete(12);
        binarySortTree.delete(9);
        binarySortTree.delete(5);
        binarySortTree.delete(2);
        binarySortTree.infixOrder();
    }

    public Node root;
    private Node left;
    private Node right;

    public BinarySortTree(Node root) {
        this.root = root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void delete(int value) {
        if (root == null) {
            System.out.println("本树为空");
            return;
        }
        root.delete(value,this);
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("本树为空");
            return;
        }
        root.infixOrder();
    }
}