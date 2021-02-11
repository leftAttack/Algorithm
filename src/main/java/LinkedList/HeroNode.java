package LinkedList;

/**
 * @author Yue_
 * @create 2021-02-09-15:48
 */
public class HeroNode {

    public int No;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String name) {
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
