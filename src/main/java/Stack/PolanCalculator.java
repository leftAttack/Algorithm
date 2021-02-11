package Stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yue_
 * @create 2021-02-10-19:00
 */
public class PolanCalculator {

        public static void main(String[] args) {
            PolanCalculator polanCalculator = new PolanCalculator(16);
            InfixExpressionToSuffixExpression infixExpressionToSuffixExpression = new InfixExpressionToSuffixExpression();
            System.out.println(polanCalculator.calculate(infixExpressionToSuffixExpression.conversion("1 + ( ( 2 + 3 ) * 4 ) - 5"))); //16
        }

    private ArrayToStack numberStack;

    public PolanCalculator(int maxSize){
        numberStack = new ArrayToStack(maxSize);
    }

    private List<String> getList(String expression){
        ArrayList<String> list = new ArrayList<>();
        String[] s = expression.split(" ");
        for(String str: s){
            list.add(str);
        }
        return list;
    }

    public int calculate(String expression){
        List<String> list = getList(expression);
        for(String item : list) {
            if (isSymbol(item)) {
                int num1 = numberStack.pop();
                int num2 = numberStack.pop();
                int res = cal(num1, num2, item);
                numberStack.push(res);
            } else {
                numberStack.push(Integer.parseInt(item));
            }
        };
        return numberStack.pop();
    }

    public int calculate(List<String> list){
        for(String item : list) {
            if (isSymbol(item)) {
                int num1 = numberStack.pop();
                int num2 = numberStack.pop();
                int res = cal(num1, num2, item);
                numberStack.push(res);
            } else {
                numberStack.push(Integer.parseInt(item));
            }
        };
        return numberStack.pop();
    }

    private boolean isSymbol(String c){
        //return c =="+" || c == "-" || c == "*" || c== "/";
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    private int cal(int num1,int num2,String operation){
        switch (operation){
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num1 * num2;
            case "/":
                return num2 / num1;
        }
        throw new RuntimeException("运算符输入有误");
    }
}
