package LinkedList;

import org.junit.Test;

/**
 * @author Yue_
 * @create 2021-02-09-15:48
 */
public class SingleLinkedListTest {

    @Test
    public void singleLinkedList(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode 宋江 = new HeroNode(1, "宋江");
        HeroNode 李逵 = new HeroNode(2, "李逵");
        HeroNode 吴用 = new HeroNode(3, "吴用");
        HeroNode 卢俊义 = new HeroNode(4, "卢俊义");
        singleLinkedList.add(宋江);
        singleLinkedList.add(李逵);
        singleLinkedList.add(卢俊义);
        singleLinkedList.add(吴用);
        singleLinkedList.show();
    }

    @Test
    public void singleLinkedListByOrder(){
        HeroNode 宋江 = new HeroNode(1, "宋江");
        HeroNode 李逵 = new HeroNode(2, "李逵");
        HeroNode 吴用 = new HeroNode(3, "吴用");
        HeroNode 卢俊义 = new HeroNode(4, "卢俊义");
        HeroNode 公孙胜 = new HeroNode(5, "公孙胜");
        HeroNode 关胜 = new HeroNode(6, "关胜");
        HeroNode 史进 = new HeroNode(7, "史进");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(吴用);
        singleLinkedList.addByOrder(李逵);
        singleLinkedList.addByOrder(卢俊义);
        singleLinkedList.addByOrder(史进);
        singleLinkedList.addByOrder(宋江);
        singleLinkedList.addByOrder(公孙胜);
        singleLinkedList.addByOrder(关胜);
        singleLinkedList.show();
    }

    @Test
    public void updateTest(){
        HeroNode 宋江 = new HeroNode(1, "宋江");
        HeroNode 李逵 = new HeroNode(2, "李逵");
        HeroNode 吴用 = new HeroNode(3, "吴用");
        HeroNode 卢俊义 = new HeroNode(4, "卢俊义");
        HeroNode 公孙胜 = new HeroNode(5, "公孙胜");
        HeroNode 关胜 = new HeroNode(4, "关胜");
        HeroNode 史进 = new HeroNode(5, "史进");
        HeroNode 康师傅 = new HeroNode(6, "康师傅");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(宋江);
        singleLinkedList.addByOrder(李逵);
        singleLinkedList.addByOrder(吴用);
        singleLinkedList.addByOrder(卢俊义);
        singleLinkedList.addByOrder(公孙胜);
        singleLinkedList.show();
        System.out.println();
        singleLinkedList.update(关胜);
        singleLinkedList.update(史进);
        singleLinkedList.update(康师傅);
        singleLinkedList.show();
    }

    @Test
    public void deleteTest(){
        HeroNode 宋江 = new HeroNode(1, "宋江");
        HeroNode 李逵 = new HeroNode(2, "李逵");
        HeroNode 吴用 = new HeroNode(3, "吴用");
        HeroNode 卢俊义 = new HeroNode(4, "卢俊义");
        HeroNode 公孙胜 = new HeroNode(5, "公孙胜");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(宋江);
        singleLinkedList.addByOrder(李逵);
        singleLinkedList.addByOrder(吴用);
        singleLinkedList.addByOrder(卢俊义);
        singleLinkedList.addByOrder(公孙胜);
        singleLinkedList.show();
        System.out.println();
        singleLinkedList.delete(5);
        singleLinkedList.show();
    }
}
