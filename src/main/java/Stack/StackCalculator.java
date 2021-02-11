package Stack;

/**
 * @author Yue_
 * @create 2021-02-10-15:46
 */
public class StackCalculator {

    public static void main(String[] args) {
        StackCalculator stackCalculator = new StackCalculator();
        stackCalculator.calculate("50*98");
    }

    private ArrayToStack numberStack; //数栈
    private ArrayToStack symbolStack; //符号栈

    public StackCalculator(){
        numberStack = new ArrayToStack(16);
        symbolStack = new ArrayToStack(16);
    }

    public int calculate(String str){
        //遍历str,将数值和符合分别入栈
        int index = 0;
        while(true){
            char c = ' ';
            if(index < str.length()) {
                 c = str.substring(index, index = index + 1).charAt(0);
            }else{
                break;
            }
            if(isSymbol(c)){
                if(symbolStack.isEmpty()){ //如果为空直接入栈
                    symbolStack.push(c);
                    continue;
                }
                if(priority(c) < priority(symbolStack.now())){
                     int num1 = numberStack.pop();
                     int num2 = numberStack.pop();
                     char operation = symbolStack.charPop();
                     numberStack.push(cal(num1,num2,operation));
                }
                symbolStack.push(c);
            }else{
                //numberStack.push(((int) c - 48)); 未处理多位数
                //处理多位数
                char nextch = ' ';
                String num = "" + c;
                while (true){
                    if(index < str.length()) {
                        if (isSymbol(nextch = str.substring(index, index + 1).charAt(0))) {
                            numberStack.push(Integer.parseInt(num));
                            break;
                        }else{
                            index ++;
                            num = num + nextch;
                        }
                    }else {
                        numberStack.push(Integer.parseInt(num));
                        break;
                    }
                }
            }
        }
        //出栈进行计算
        while (true){
            if(symbolStack.isEmpty()){
                System.out.println("计算结果为:" + numberStack.pop());
                break;
            }
            int num1 = numberStack.pop();
            int num2 = numberStack.pop();
            char operation = symbolStack.charPop();
            numberStack.push(cal(num1,num2,operation));
        }
        return -1;
    }

    private boolean isSymbol(char c){
        return c =='+' || c == '-' || c == '*' || c== '/';
    }

    private int priority(char c){
        if(c == '*' || c== '/'){
            return 1;
        }else if(c == '+' || c== '-'){
            return 0;
        }
        return -1;
    }

    private int cal(int num1,int num2,char operation){
       switch (operation){
           case '+':
               return num1 + num2;
           case '-':
               return num2 - num1;
           case '*':
               return num1 * num2;
           case '/':
               return num2 / num1;
       }
       throw new RuntimeException("运算符输入有误");
    }
}
