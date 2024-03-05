package org.java.ds;

class LinkedList {
    static Node head;
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node reverse(Node head){
        Node prev=null;
        Node current=head;
        Node next;
        while(current !=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        return head;
    }

    public int findNode(Node head,int data){
        int pos=1;
        while(head !=null){
            if(head.data==data) {
                System.out.println("Node found at "+pos);
                return pos;
            }
            pos++;
            head=head.next;
        }
        return -1;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.next = new Node(30);
        list.head.next.next.next.next.next = new Node(90);
        System.out.println("Given linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
        System.out.println("");
        System.out.println(list.findNode(head,4));
    }
}
