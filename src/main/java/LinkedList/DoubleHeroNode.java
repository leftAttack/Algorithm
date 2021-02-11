package LinkedList;

/**
 * @author Yue_
 * @create 2021-02-10-11:55
 */
public class DoubleHeroNode {

    public int No;
    public String name;
    public DoubleHeroNode next;
    public DoubleHeroNode pre;

    public DoubleHeroNode(int no, String name) {
        No = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "No=" + No +
                ", name='" + name +
                '}';
    }
}
