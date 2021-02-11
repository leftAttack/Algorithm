package Queue;

/**
 * @author Yue_
 * @create 2021-02-09-14:25
 */
public class CircularQueue {

    private int front;
    private int rear;
    private int maxSize;
    private int[] array;

    public CircularQueue(int maxSize){
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = 0; //此时front指向头元素的位置
        rear = 0;  //此时rear指向尾元素的后一个位置
    }

    public void add(int item){
        if((rear + 1 + maxSize) % maxSize == front){
            System.out.println("队列已满");
        }else {
            System.out.println("入队成功");
            array[rear] = item;
            rear = (rear + 1) % maxSize;
        }
    }

    public int off(){
        if(rear == front){
            System.out.println("队列为空");
            return -1;
        }else {
            System.out.println("出队成功");
            int temp = array[front];
            front = (front + 1) % maxSize;
            return temp;
        }
    }

    public void show(){
        for(int item: array){
            System.out.print(item);
        }
    }
}
