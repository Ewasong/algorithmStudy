package challenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QuqueUse {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);  //{1}
        queue.offer(2);  //{1,2}
        queue.offer(3);  //{1,2,3}
        System.out.println(queue.toString());
        System.out.println(queue.peek());   //1
        queue.poll();    // {2,3}
        System.out.println(queue.peek());   // 2
        queue.poll();    // {3}
        System.out.println(queue.peek());   // 3
        queue.poll();    // {}

    }
}
