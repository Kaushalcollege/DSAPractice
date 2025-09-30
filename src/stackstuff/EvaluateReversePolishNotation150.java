package stackstuff;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(new EvaluateReversePolishNotation150().evalRPN(tokens));
        System.out.println(new EvaluateReversePolishNotation150().evalRPN1(tokens));
    }
    public int evalRPN(String[] tokens) {
        String str = String.join(" ", tokens);
        System.out.println(str);
        Stack<Integer> stack = new Stack<>();
        for (String t : str.split(" ")){
            if (t.matches("-?\\d+")) stack.push(Integer.parseInt(t));
            else{
                int b = stack.pop();
                int a = stack.pop();
                switch(t){
                    case "+" : stack.push(a + b); break;
                    case "-" : stack.push(a - b); break;
                    case "*" : stack.push(a * b); break;
                    case "/" : stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens){

            char c = s.charAt(0);

            if (c == '+'){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            }

            else if (c == '-' && s.length() == 1){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            }

            else if (c == '*'){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            }

            else if (c == '/'){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }

            else{
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
