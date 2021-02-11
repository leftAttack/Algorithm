package LinkedList;

import org.junit.Test;

/**
 * @author Yue_
 * @create 2021-02-09-20:31
 */
public class SingleLinkedListInterviewTest {

    private SingleLinkedListInterview interview = new SingleLinkedListInterview();

    public SingleLinkedList getLinkedList(){
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
        return singleLinkedList;
    }


    //1.求单链表有效节点个数
    @Test
    public void getAllNodes(){
        System.out.println(interview.getAllNodes(getLinkedList()));
    }

    //2.查找单链表的倒数第k个节点【新浪】
    @Test
    public void getHeroNodeByK(){
        System.out.println(interview.getHeroNodeByK(getLinkedList(), 1));
    }

    //3.单链表的反转【腾讯】
    @Test
    public void reverseLinkedList(){
        SingleLinkedList linkedList = getLinkedList();
        linkedList.show();
        System.out.println();
        interview.reverseLinkedList(linkedList);
        linkedList.show();
    }

    //4.从头到尾打印单链表【百度 要求方式1:反向遍历  方式2:栈】
    @Test
    public void printReverseLinkedList(){
        SingleLinkedList linkedList = getLinkedList();
        linkedList.show();
        System.out.println();
        interview.printReverseLinkedList(linkedList);
    }

    //5.合并两个有序的单链表，合并之后的链表依然有序


}
