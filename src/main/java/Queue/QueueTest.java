package Queue;

import org.junit.Test;

import java.security.PublicKey;

/**
 * @author Yue_
 * @create 2021-02-09-13:43
 */
public class QueueTest {

    @Test
    public void arrayQueueTest(){
        ArraryToQueue queue = new ArraryToQueue(8);
        for(int i = 1; i <= 10 ; i++) {
            queue.add(i);
        }
        queue.show();
        System.out.println();
        for(int i = 1; i <= 10 ; i++) {
            System.out.println(queue.off());
        }
    }

    @Test
    public void arrayCircularQueueTest(){
        CircularQueue queue = new CircularQueue(8);
        for(int i = 1; i <= 10 ; i++) {
            queue.add(i);
        }
        queue.show();
        System.out.println();
        for(int i = 1; i <= 10 ; i++) {
            System.out.println(queue.off());
        }

    }
}
