package com.company.binary_search_tree;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            bst.insert(scanner.nextInt());
        }

        System.out.print("inorder: ");
        bst.printInOrder(bst.root);
        System.out.println();

        System.out.print("preorder: ");
        bst.printPreOrder(bst.root);
        System.out.println();

        System.out.print("postorder: ");
        bst.printPostOrder(bst.root);
        System.out.println();
    }
}

class BinarySearchTree {
    Node root;

    class Node {
        int data;
        Node left, right;
        Node root;

        Node(int data) {
            this.data = data;
        }
    }

    void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node tmp = root;

            while (true) {
                if (data < tmp.data) //kiri
                {
                    if (tmp.left != null) {
                        tmp = tmp.left;
                    } else {
                        tmp.left = new Node(data);
                        tmp.left.root = tmp;
                        break;
                    }
                } else if (data > tmp.data) //kanan
                {
                    if (tmp.right != null) {
                        tmp = tmp.right;
                    } else {
                        tmp.right = new Node(data);
                        tmp.right.root = tmp;
                        break;
                    }
                }else{
                    break;
                }
            }
        }
    }

    void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + ",");
            printInOrder(node.right);
        }
    }

    void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + ",");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + ",");
        }
    }
}
