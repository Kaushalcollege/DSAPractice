package stackstuff;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InBuiltExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(18);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(34);
        queue.add(45);
        queue.add(2);
        queue.add(18);
        queue.add(9);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
    }
}
