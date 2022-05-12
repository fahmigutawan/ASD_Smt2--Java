package com.company.binary_search_tree_2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            bst.insert(scanner.nextInt());
        }

        bst.calculateLeafCount(bst.root);

        bst.printLeafCount();
    }
}

class BinarySearchTree {
    Node root;
    int leafCount;

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
                } else {
                    break;
                }
            }
        }
    }

    void calculateLeafCount(Node node) {
        if (node == null) {
            leafCount += 0;
        } else if (node.left == null && node.right == null) {
            leafCount += 1;
        } else {
            calculateLeafCount(node.left);
            calculateLeafCount(node.right);
        }
    }

    void printLeafCount(){
        System.out.println(leafCount);
    }
}

