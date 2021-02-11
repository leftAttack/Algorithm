package Stack;


/**
 * @author Yue_
 * @create 2021-02-10-15:11
 */
public class ArrayToStack {

    public int top;
    private int maxSize;
    private Object[] array;

    public ArrayToStack(int maxSize){
        this.maxSize = maxSize;
        array = new Object[maxSize];
        top = -1;
    }

    public void push(int data){
        if(isFull()){
            return;
        }
        top ++;
        array[top] = data;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("栈为空");
            return -1;
        }
        int value = (int) array[top];
        top --;
        return value;
    }

    public char charPop(){
        if(isEmpty()){
            System.out.println("栈为空");
            return ' ';
        }
        char value = (char) array[top];
        top --;
        return value;
    }

    public char now(){
        if(isEmpty()){
            System.out.println("栈为空");
            return ' ';
        }
        char value = (char) array[top];
        return value;
    }

    public String nowString(){
        if(isEmpty()){
            System.out.println("栈为空");
            return null;
        }
        Integer value = (Integer) array[top];
        return value.toString();
    }


    public boolean isFull(){
        if(top >= maxSize -1){
            System.out.println("栈已满");
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(top < 0){
            //System.out.println("栈为空");
            return true;
        }
        return false;
    }
}

class StringStack{

    public int top;
    private int maxSize;
    private Object[] array;

    public StringStack(int maxSize){
        this.maxSize = maxSize;
        array = new String[maxSize];
        top = -1;
    }

    public void push(Object data){
        if(isFull()){
            return;
        }
        top ++;
        array[top] = data;
    }

    public Object pop(){
        if(isEmpty()){
            System.out.println("栈为空");
            return null;
        }
        String value = (String) array[top];
        top --;
        return value;
    }

    public Object now(){
        if(isEmpty()){
            System.out.println("栈为空");
            return null;
        }
        String value = (String) array[top];
        return value;
    }

    public boolean isFull(){
        if(top >= maxSize -1){
            System.out.println("栈已满");
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(top < 0){
            //System.out.println("栈为空");
            return true;
        }
        return false;
    }

}
