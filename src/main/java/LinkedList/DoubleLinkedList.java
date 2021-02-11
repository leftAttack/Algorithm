package LinkedList;

/**
 * @author Yue_
 * @create 2021-02-10-11:55
 */
public class DoubleLinkedList {

    private DoubleHeroNode head;

    public DoubleLinkedList(){
         head = new DoubleHeroNode(0, "");
    }

    public void add(DoubleHeroNode heroNode){
        //遍历链表
        DoubleHeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void addByOrder(DoubleHeroNode heroNode){
        //遍历链表
        DoubleHeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.No > heroNode.No){
                break;
            }
            temp = temp.next;
        }
        heroNode.pre = temp;
        if(temp.next != null) {
            heroNode.next = temp.next;
            temp.next.pre = heroNode;
        }
        temp.next = heroNode;
    }

    public void update(DoubleHeroNode heroNode){
        //遍历链表
        DoubleHeroNode temp = head;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.No == heroNode.No){
                temp.name = heroNode.name;
            }
            temp = temp.next;
        }
    }

    public void delete(int No){
        //遍历链表
        DoubleHeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.No == No){
                temp.pre.next = temp.next;
                if(temp.next != null){
                temp.next.pre = temp.pre;
                }
            }
            temp = temp.next;
        }
    }

    public void show(){
        //遍历链表
        DoubleHeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void reverseshow(){
        //遍历链表
        DoubleHeroNode temp = head.next;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        while (true){
            if(temp.pre == null){
                break;
            }
            System.out.println(temp);
            temp = temp.pre;
        }
    }
}
