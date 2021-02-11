package Stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Yue_
 * @create 2021-02-10-20:34
 */
public class InfixExpressionToSuffixExpression {

    public static void main(String[] args) {
        InfixExpressionToSuffixExpression suffixExpression = new InfixExpressionToSuffixExpression();
        System.out.println(suffixExpression.conversion("1 + ( ( 2 + 3 ) * 4 ) - 5"));
    }

   private Stack<String> numberStack;
   private Stack<String> symbolStack;

   public InfixExpressionToSuffixExpression(){
       numberStack = new Stack();
       symbolStack = new Stack();
   }

    private List<String> getList(String expression){
        ArrayList<String> list = new ArrayList<>();
        String[] s = expression.split(" ");
        for(String str: s){
            list.add(str);
        }
        return list;
    }

    public List<String> conversion(String expression){
        List<String> list = getList(expression);
        for(String item : list){
            if(isSymbol(item)){
                while (true) {
                    if (symbolStack.isEmpty() || isLeftBrackets(symbolStack.peek())) {
                        symbolStack.push(item);
                        break;
                    } else if (priority(item) > priority(symbolStack.peek())) {
                        symbolStack.push(item);
                        break;
                    } else {
                        numberStack.push(symbolStack.pop());
                    }
                }
            }
            else if(isLeftBrackets(item)){
                symbolStack.push(item);
            }
            else if(isRigjtBrackets(item)){
                 while (true){
                     String str = symbolStack.pop();
                     if(isLeftBrackets(str)){
                         break;
                     }
                     numberStack.push(str);
                 }
            }else {
                numberStack.push(item);
            }
        };
        while (true) {
            if (symbolStack.isEmpty()) {
                break;
            }
            numberStack.push(symbolStack.pop());
        }
        String[] array = new String[numberStack.size()];
        for(int j = numberStack.size() - 1; j >= 0; j--){
                array[j] = numberStack.pop();
        }
        return Arrays.asList(array);
    }

    private boolean isSymbol(String c){
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    private boolean isLeftBrackets(String c){
       return c.equals("(");
    }

    private boolean isRigjtBrackets(String c){
        return c.equals(")");
    }

    private int priority(String c){
        if(c == "*" || c== "/"){
            return 1;
        }else if(c == "+" || c== "-"){
            return 0;
        }
        return -1;
    }
}
