package org.java.ds;

public class LinkedListNode {
    int value;
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
    }

}
