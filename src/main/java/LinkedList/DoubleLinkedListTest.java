package LinkedList;

import org.junit.Test;

/**
 * @author Yue_
 * @create 2021-02-10-12:03
 */
public class DoubleLinkedListTest {

    private DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

    @Test
    public void add(){
        DoubleHeroNode 宋江 = new DoubleHeroNode(1, "宋江");
        DoubleHeroNode 李逵 = new DoubleHeroNode(2, "李逵");
        DoubleHeroNode 吴用 = new DoubleHeroNode(3, "吴用");
        DoubleHeroNode 卢俊义 = new DoubleHeroNode(4, "卢俊义");
        doubleLinkedList.add(宋江);
        doubleLinkedList.add(李逵);
        doubleLinkedList.add(吴用);
        doubleLinkedList.add(卢俊义);
        doubleLinkedList.show();
        System.out.println();
        doubleLinkedList.reverseshow();
    }

    @Test
    public void addByOrder(){
        DoubleHeroNode 宋江 = new DoubleHeroNode(1, "宋江");
        DoubleHeroNode 李逵 = new DoubleHeroNode(2, "李逵");
        DoubleHeroNode 吴用 = new DoubleHeroNode(3, "吴用");
        DoubleHeroNode 卢俊义 = new DoubleHeroNode(4, "卢俊义");
        doubleLinkedList.addByOrder(卢俊义);
        doubleLinkedList.addByOrder(吴用);
        doubleLinkedList.addByOrder(李逵);
        doubleLinkedList.addByOrder(宋江);
        doubleLinkedList.show();
    }

    @Test
    public void update(){
        DoubleHeroNode 宋江 = new DoubleHeroNode(1, "宋江");
        DoubleHeroNode 李逵 = new DoubleHeroNode(2, "李逵");
        DoubleHeroNode 吴用 = new DoubleHeroNode(3, "吴用");
        DoubleHeroNode 卢俊义 = new DoubleHeroNode(4, "卢俊义");
        DoubleHeroNode 公孙胜 = new DoubleHeroNode(2, "公孙胜");
        DoubleHeroNode 关胜 = new DoubleHeroNode(3, "关胜");
        doubleLinkedList.add(宋江);
        doubleLinkedList.add(李逵);
        doubleLinkedList.add(吴用);
        doubleLinkedList.add(卢俊义);
        doubleLinkedList.show();
        System.out.println();
        doubleLinkedList.update(公孙胜);
        doubleLinkedList.update(关胜);
        doubleLinkedList.show();
    }

    @Test
    public void delete(){
        DoubleHeroNode 宋江 = new DoubleHeroNode(1, "宋江");
        DoubleHeroNode 李逵 = new DoubleHeroNode(2, "李逵");
        DoubleHeroNode 吴用 = new DoubleHeroNode(3, "吴用");
        DoubleHeroNode 卢俊义 = new DoubleHeroNode(4, "卢俊义");
        doubleLinkedList.add(宋江);
        doubleLinkedList.add(李逵);
        doubleLinkedList.add(吴用);
        doubleLinkedList.add(卢俊义);
        doubleLinkedList.show();
        System.out.println();
        doubleLinkedList.delete(2);
        doubleLinkedList.delete(3);
        doubleLinkedList.delete(4);
        doubleLinkedList.show();
    }


}
