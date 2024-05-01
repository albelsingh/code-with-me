package org.java.ds;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.HashSet;

public class LinkedListNode {
    int value;
    int flag;
    LinkedListNode next;

    public LinkedListNode(int value, LinkedListNode next) {
        super();
        this.value = value;
        this.next = next;
    }

    public static int findMidElement(LinkedListNode head) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        while (p1 != null) {

            p2 = p2.next.next;
            p1 = p1.next;
            if (p2 == null || p2.next == null) {
                System.out.println("Mid element is " + p1.value);
                break;
            }
        }
        return 0;
    }

    static void detectLoop(LinkedListNode head)
    {
        LinkedListNode slow_p = head, fast_p = head;
        int flag = 0;
        while (slow_p != null && fast_p != null
                && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop Found");
        else
            System.out.println("No Loop");
    }

    static boolean detectLoop1(LinkedListNode h)
    {
        while (h != null) {

            // If this node is already traverse
            // it means there is a cycle
            // (Because you we encountering the
            // node for the second time).
            if (h.flag == 1)
                return true;

            // If we are seeing the node for
            // the first time, mark its flag as 1
            h.flag = 1;

            h = h.next;
        }
        return false;
    }
    static boolean detectLoop2(LinkedListNode h)
    {
        HashSet<LinkedListNode> s = new HashSet<LinkedListNode>();
        while (h != null) {
            // If we have already has this node
            // in hashmap it means there is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(h))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(h);

            h = h.next;
        }

        return false;
    }


    public static void main(String[] args) {
        //1->3->6->11->5->9->2
        //p1,p2
        LinkedListNode node2 = new LinkedListNode(2, null);
        LinkedListNode node9 = new LinkedListNode(9, node2);
        LinkedListNode node5 = new LinkedListNode(5, node9);
        LinkedListNode node11 = new LinkedListNode(11, node5);
        LinkedListNode node6 = new LinkedListNode(6, node11);
        LinkedListNode node3 = new LinkedListNode(3, node6);
        LinkedListNode node1 = new LinkedListNode(1, node3);
        findMidElement(node1);
        node2.next=node1;
        detectLoop(node1);

    }

}
