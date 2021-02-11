package LinkedList;

import java.util.Stack;

/**
 * @author Yue_
 * @create 2021-02-09-20:25
 */
public class SingleLinkedListInterview {

    //1.求单链表有效节点个数
    public int getAllNodes(SingleLinkedList linkedList){
        HeroNode temp = linkedList.head.next;
        int sum = 0;
        while (true){
            if(temp == null){
                break;
            }
            temp = temp.next;
            sum ++;
        }
        return sum;
    }

    //2.查找单链表的倒数第k个节点【新浪】
    public HeroNode getHeroNodeByK(SingleLinkedList linkedList,int k){
        int length = getAllNodes(linkedList);
        int index = length - k + 1;
        HeroNode temp = linkedList.head;
        if(index <= 0 || index > length){
            System.out.println("您的输入有误");
        }
        for(int i = 0; i < index ; i++){
             temp = temp.next;
        }
        return temp;
    }
    //3.单链表的反转【腾讯】
    //思路:
    //1.先定义一个reverseHead = new HeroNode()
    //2.从头到尾遍历原来的链表,每遍历一个节点,就将其取出并放在reverseHead的最前端
    //3.原来链表的head.next = reverseHead.next
    public void reverseLinkedList(SingleLinkedList linkedList){
        if(linkedList.head.next == null || linkedList.head.next.next == null){
            System.out.println("无需反转");
            return;
        }
        HeroNode temp = linkedList.head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "");
        while (true){
            if(temp == null){
                break;
            }
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        linkedList.head.next = reverseHead.next;
    }

    //4.从头到尾打印单链表【百度 要求方式1:反向遍历  方式2:栈】
    public void printReverseLinkedList(SingleLinkedList linkedList){
        if(linkedList.head.next == null || linkedList.head.next.next == null){
            linkedList.show();
            return;
        }
        HeroNode temp = linkedList.head.next;
        Stack<HeroNode> heroNodes = new Stack<>();
        while (true){
            if(temp == null){
                break;
            }
            heroNodes.add(temp);
            temp = temp.next;
        }
        while (true){
            if(heroNodes.empty()){
                break;
            }
            System.out.println(heroNodes.pop());
        }
    }

    //5.合并两个有序的单链表,合并之后的链表依然有序

}
