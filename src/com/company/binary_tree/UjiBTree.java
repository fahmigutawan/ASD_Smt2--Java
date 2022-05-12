package com.company.binary_tree;

/**
 *
 * @author USER
 */
public class UjiBTree {
    public static void main(String[] args){ 
        BTree btree = new BTree();
        btree.tambah(100);
        btree.tambah(75);
        btree.tambah(150);
        btree.tambah(80);
        btree.tambah(130);
        btree.tambah(45);
        btree.tambah(60);
         btree.tambah(160);
        System.out.println("PreOrder");
        btree.preOrder(btree.getRoot()); System.out.println("\n");
        System.out.println("InOrder");
        btree.inOrder(btree.getRoot()); System.out.println("\n");
        System.out.println("PostOrder");
        btree.postOrder(btree.getRoot()); System.out.println("\n");
    }
}
