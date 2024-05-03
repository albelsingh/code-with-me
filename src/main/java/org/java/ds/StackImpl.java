package org.java.ds;

import java.util.LinkedList;
import java.util.Queue;

public class StackImpl {
    /**
     * Follow the below steps to implement the push(s, x) operation:
     * Enqueue x to q2.
     * One by one dequeue everything from q1 and enqueue to q2.
     * Swap the queues of q1 and q2.
     * Follow the below steps to implement the pop(s) operation:
     * Dequeue an item from q1 and return it.
     */
    static class Stack {
        // Two inbuilt queues
        static Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();

        // To maintain current number of
        // elements
        static int curr_size;

        static void push(int x)
        {
            // Push x first in empty q2
            q2.add(x);

            // Push all the remaining
            // elements in q1 to q2.
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }

            // swap the names of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        static void pop()
        {

            // if no elements are there in q1
            if (q1.isEmpty())
                return;
            q1.remove();
        }

        static int top()
        {
            if (q1.isEmpty())
                return -1;
            return q1.peek();
        }

        static int size() { return q1.size(); }
    }

    // driver code
    public static void main(String[] args)
    {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.push(10);
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }
}
