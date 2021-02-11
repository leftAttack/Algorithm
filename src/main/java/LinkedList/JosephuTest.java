package LinkedList;

import org.junit.Test;

/**
 * @author Yue_
 * @create 2021-02-10-12:56
 */
public class JosephuTest {

    @Test
    public void addTest(){
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(25);
        circleLinkedList.show();
    }

    @Test
    public void josephuTest(){
        Josephu josephu = new Josephu();
        josephu.josephuPlay(5,1,2);
    }
}
