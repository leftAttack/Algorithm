package Queue;

/**
 * @author Yue_
 * @create 2021-02-09-13:43
 */
public class ArraryToQueue {

    private int rear; //队列尾
    private int front; //队列头
    private int maxSize; //队列长度
    private int[] array;

    public ArraryToQueue(int maxSize){
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = -1;  //front是指向队列头的前一个位置
        rear = -1;   //rear指向队列尾
    }

    //入队操作
    public void add(int item){
        if(rear < maxSize -1) {
            rear++;
            array[rear] = item;
            System.out.println("入队成功");
        }else{
            System.out.println("队列满");
        }
    }

    //出队操作
    public int off(){
       if(front <= rear - 1) {
           front++;
           int item = array[front];
           System.out.println("出队成功");
           return item;
       }else {
           System.out.println("已全部出队");
           return -1;
       }
    }

    public void show(){
        for(int item: array){
            System.out.print(item);
        }
    }
}
