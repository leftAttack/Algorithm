package LinkedList;

/**
 * @author Yue_
 * @create 2021-02-10-12:55
 */
public class CircleLinkedList {

    public HeroNode first;

    public CircleLinkedList(){

    }

    public void add(int nums){
      if(nums < 1){
          System.out.println("nums输入有误");
      }
      HeroNode temp = first;
      for(int i = 1; i <= nums ; i++){
          HeroNode heroNode = new HeroNode(i, i + "号人物");
          if(i == 1){
              first = heroNode;
              heroNode.next = first;
              temp = first;
          }else{
              temp.next = heroNode;
              heroNode.next = first;
              temp = heroNode;
          }
      }
    }

    public void show(){
        if(first.next == null){
            System.out.println("链表为空");
        }
        //遍历链表
        HeroNode temp = first;
        while (true){
            System.out.println(temp);
            if(temp.next == first){
                break;
            }
            temp = temp.next;
        }
    }
}
