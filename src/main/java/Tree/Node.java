package Tree;

/**
 * @author Yue_
 * @create 2021-02-14-21:34
 */
public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else {
            if (value < this.value) {
                if (this.left != null) {
                    return this.left.search(value);
                }
            } else {
                if (this.right != null) {
                    return this.right.search(value);
                }
            }
        }
        return null;
    }

    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            }
        }
        return null;
    }

    public Node searchMin(Node node) {
        if (node.left == null) {
            return node;
        }
        if (node.left != null && node.left.left == null) {
            Node node1 = node.left;
            node.left = null;
            return node1;
        }
        return searchMin(node.left);
    }

    public void delete(int value, BinarySortTree binarySortTree) {
        //删除叶子节点的情况
        Node delNode = search(value);
        Node parentNode = searchParent(value);
        if (delNode.left == null && delNode.right == null) {
            if (parentNode != null) {
                System.out.println("删除叶子节点的情况");
                if (parentNode.value > delNode.value) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            } else {
                System.out.println("删除最后一个节点");
                binarySortTree.root = null;
            }
        }
        //删除只有一颗子树的情况
        else if ((delNode.left == null && delNode.right != null) || (delNode.right == null && delNode.left != null)) {
            System.out.println("删除只有一颗子树的情况");
            if (parentNode != null) {
                //子树是左节点的情况
                if (parentNode != null) {
                    if (delNode.right == null) {
                        //待删除的节点为左节点的情况
                        if (parentNode.value > delNode.value) {
                            parentNode.left = delNode.left;
                        } else {
                            parentNode.right = delNode.left;
                        }
                    }
                } else {
                    //root节点指向左边
                    binarySortTree.root = delNode.left;
                }
                //子树是右节点的情况
                if (parentNode != null) {
                    if (delNode.left == null) {
                        //待删除的节点为左节点的情况
                        if (parentNode.value > delNode.value) {
                            parentNode.left = delNode.right;
                        } else {
                            parentNode.right = delNode.right;
                        }
                    }
                } else {
                    //root节点指向右边
                    binarySortTree.root = delNode.right;
                }
            }
        }
        //删除有两颗子树的情况
        else if (delNode.left != null && delNode.right != null) {
            Node min;
            System.out.println("删除有两颗子数的情况");
            //递归寻找右子树中值最小的节点并进行删除
            if (delNode.right.left == null) {
                min = delNode.right;
                delNode.right = null;
            } else {
                min = searchMin(delNode.right);
            }
            delNode.value = min.value;
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height() + 1;
    }

    //右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height() + 1;
    }

    //左旋转
    public void leftRevolve() {
        if (rightHeight() - leftHeight() > 1) {
            //创建一个新的节点
            Node newNode = new Node(value);
            //把新节点的左子树设置为当前节点的左子树
            newNode.left = left;
            //把新节点的右子树设置为当前节点的右子树的左子树
            newNode.right = right.left;
            //把当前节点的根节点设置为右子节点
            value = right.value;
            //把当前节点的右子树设置成右子树的右子树
            right = right.right;
            //把当前节点的左子树设置为新节点
            left = newNode;
        }
    }

    public void rightRevolve() {
        if (leftHeight() - rightHeight() > 1) {
            Node newNode = new Node(value);
            newNode.right = right;
            newNode.left = left.right;
            value = left.value;
            left = left.left;
            right = newNode;
        }
    }

    public void doubleRevolve() {
        // 右旋转 [考虑到双旋转问题]
        if (leftHeight() - rightHeight() > 1) {
            if (left.leftHeight() < left.rightHeight()) {
                left.leftRevolve();
                rightRevolve();
            } else {
                rightRevolve();
            }
        }
        else if (rightHeight() - leftHeight() > 1) {
            if (right.rightHeight() < right.leftHeight()) {
                right.rightRevolve();
                leftRevolve();
            } else {
                leftRevolve();
            }
        }
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
