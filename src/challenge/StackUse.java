package challenge;

import java.util.Stack;

public class StackUse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);  //{1}
        stack.push(2);  //{1,2}
        stack.push(3);  //{1,2,3}
        System.out.println(stack.peek());   //3
        stack.pop();    // {1,2}
        System.out.println(stack.peek());   // 2
        stack.pop();    // {1}
        System.out.println(stack.peek());   // 1
        stack.pop();    // {}

    }
}
