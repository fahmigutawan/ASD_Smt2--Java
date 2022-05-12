package com.company.binary_tree;

/**
 *
 * @author USER
 */
public class BTree {
    //Atribut
    private NodeBT root;
    //konstruktor
    public BTree(){
        root=null;
    }
    //methods
    public void setRoot(NodeBT root){
        this.root=root;
    }
    public NodeBT getRoot(){
        return this.root;
    }
    public boolean kosong(){
        if(root==null) return true;
        else return false;
    }
    //tambah elemen tree
    public void tambah(int data){
        NodeBT baru = new NodeBT();
        baru.setData(data);
        if(kosong()) root=baru;
        else {
            NodeBT p,t;
            p=t=this.root;
            boolean kiri=true;
            while(t!=null){
                p=t;
                if(data<t.getData()){
                    kiri=true;
                    t=t.getKiri();
                } else {
                    kiri=false;
                    t=t.getKanan();
                }
            }
            if(kiri) p.setKiri(baru);
            else p.setKanan(baru);
        }
    }
    //Mencetak preOrder
    public void preOrder(NodeBT root){
        if(root!=null){
            System.out.print(root.getData()+", ");
            preOrder(root.getKiri());
            preOrder(root.getKanan());
        }
    }
    //Mencetak inOrder
    public void inOrder(NodeBT root){
        if(root!=null){
            inOrder(root.getKiri());
            System.out.print(root.getData()+"  ");
            inOrder(root.getKanan());
        }
    }
    //Mencetak postOrder
    public void postOrder(NodeBT root){
        if(root!=null){
            postOrder(root.getKiri());
            postOrder(root.getKanan());
            System.out.print(root.getData()+"  ");
        }
    }
}
