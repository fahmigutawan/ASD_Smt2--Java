package com.company.avl_tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AvlTree avl = new AvlTree();
        ArrayList<Integer> numberInput = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String tmp = scanner.nextLine();
            int number = Integer.parseInt(tmp.substring(7));

            if (tmp.contains("insert")) {
                numberInput.add(number);
            } else if (tmp.contains("delete")) {
                for (int j = 0; j < numberInput.size(); j++) {
                    if (number == numberInput.get(j)) {
                        numberInput.remove(j);
                        break;
                    }
                }
            }
        }

        for (int tmp : numberInput) {
            avl.insert(tmp);
        }

        avl.print();
    }
}

class AvlTree {
    Node root;
    Node parentDeleted;
    Node nodeLeftDeleted;
    Node nodeRightDeleted;

    class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    public void insert(int data) {
        root = rekursifInsert(data, root);
    }

    private Node rekursifInsert(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = rekursifInsert(data, node.left);
        } else if (data > node.data) {
            node.right = rekursifInsert(data, node.right);
        } else {
            return node;
        }

        node.height = updateHeight(node);

        Node tmp = balancingTree(data, node);

        return tmp;
    }

    private Node balancingTree(int data, Node node) {
        int balanceFactor = balanceFactor(node);

        if (balanceFactor > 1) {
            if (data < node.left.data) {
                node = rightRotate(node);
            } else if (data > node.left.data) {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (data < node.right.data) {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            } else if (data > node.right.data) {
                node = leftRotate(node);
            }
        }

        return node;
    }

    private int balanceFactor(Node node) {
        if (node == null) return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    private int updateHeight(Node node) {
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private Node leftRotate(Node node) {
        Node tmp = node.right;
        Node tmpLeft = node.right.left;

        tmp.left = node;
        node.right = tmpLeft;

        node.height = updateHeight(node);
        tmp.height = updateHeight(tmp);

        return tmp;
    }

    private Node rightRotate(Node node) {
        Node tmp = node.left;
        Node tmpRight = node.left.right;

        tmp.right = node;
        node.left = tmpRight;

        node.height = updateHeight(node);
        tmp.height = updateHeight(tmp);
        return tmp;
    }

    public void print() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + ",");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
