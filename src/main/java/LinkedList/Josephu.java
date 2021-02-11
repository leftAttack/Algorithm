package LinkedList;

/**
 * @author Yue_
 * @create 2021-02-10-13:40
 */

/*
设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列
 */
public class Josephu {

   private CircleLinkedList circleLinkedList =  new CircleLinkedList();

   public void josephuPlay(int n,int k,int m){
       //数据校验
       if(n < 1 || k < 1 || k > n || m < 1){
           System.out.println("参数输入有误");
           return;
       }
       circleLinkedList.add(n);
       HeroNode first = circleLinkedList.first;
       HeroNode helper = first;
       for(int i = 1;i < k; i++){
            first = first.next;  //first指向第k个元素
       }
       for(int i2 = 1;i2 < n+k-1; i2++){
           helper = helper.next;  //helper辅助节点指first节点的前一个位置
       }
       while (true){
           if(helper == first){  //此时圈内只有一个小孩
               break;
           }
           for(int i3 = 1;i3 < m;i3++){
               first = first.next;
               helper = helper.next;
           }
           System.out.println(first);
           first = first.next;
           helper.next = first;
       }
   }
}
