package org.java.ds;

public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int val){
            this.data=val;
        }
    }
    public static Node insert(Node node,int val){
        if(node==null){
            node = new Node(val);
            return node;
        }
        if(val<node.data){
            node.left=insert(node.left,val);
        }
        else
            node.right=insert(node.right,val);

        return node;
    }

    public static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void printTopView(Node root){
        if(root==null)
            return;
        printLeftBST(root.left);
        System.out.println(root.data);
        printRightBST(root.right);
    }

    public static void printLeftBST(Node root){
        if(root==null)
            return;
        printLeftBST(root.left);
        System.out.println(root.data);
    }

    public static void printRightBST(Node root){
        if(root==null)
            return;
        System.out.println(root.data);
        printRightBST(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null)
            return false;

        if(root.data>key){ //left subtree
            return search(root.left,key);
        } else if (root.data<key) {
            return search(root.right,key);
        } else { //root data is equal to key
            return true;
        }
    }

    public static void main(String[] args) {
        //int[] values={5,1,3,4,2,7};
        int[] values={4,5,6,7,11,10,12};
        Node node=null;

        for (int value : values) {
            node = insert(node, value);
        }

        inorder(node);
        System.out.println("Top View");
        printTopView(node);

        if(search(node,0)){
            System.out.println("found");
        }
        else {
            System.out.println("Not Found");
        }
    }
}
