package Stack;

import org.junit.Test;

/**
 * @author Yue_
 * @create 2021-02-10-15:18
 */
public class StackTest {

    @Test
    public void stack(){
        ArrayToStack arrayToStack = new ArrayToStack(4);
        arrayToStack.push(1);
        arrayToStack.push(2);
        arrayToStack.push(3);
        arrayToStack.push(4);
        arrayToStack.push(5);
        System.out.println(arrayToStack.pop());
        System.out.println(arrayToStack.pop());
        System.out.println(arrayToStack.pop());
        System.out.println(arrayToStack.pop());
        System.out.println(arrayToStack.pop());
    }
}
