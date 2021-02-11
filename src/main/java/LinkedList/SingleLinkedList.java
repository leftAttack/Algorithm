package LinkedList;

/**
 * @author Yue_
 * @create 2021-02-09-15:47
 */
public class SingleLinkedList {

    public HeroNode head;

    public SingleLinkedList(){
        head = new HeroNode(0,"");
    }

    public void add(HeroNode heroNode){
        //遍历链表
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        //遍历链表
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null){
                break;
            }
            if (temp.next.No > heroNode.No){
                break;
            }else if(temp.next.No == heroNode.No){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
        if(flag == true){
            System.out.println("该节点已被添加");
        }
    }

    public void update(HeroNode newHeroNode){
        //遍历链表
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.No == newHeroNode.No){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true){
            temp.name = newHeroNode.name;
        }else{
            System.out.println("未找到编号为" + newHeroNode.No + "的节点");
        }
    }

    public void delete(int No){
        //遍历链表
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.No == No){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag == true){
            //没有引用指向,被GC
            temp.next = temp.next.next;
        }else{
            System.out.println("未找到编号为" + No + "的节点进行删除");
        }
    }

    public void show(){
        if(head.next == null){
            System.out.println("链表为空");
        }
        //遍历链表
        HeroNode temp = head.next;
        while (true){
            System.out.println(temp);
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }
}
