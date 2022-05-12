package com.company.binary_tree;

/**
 *
 * @author USER
 */
public class NodeBT {
    private int data;
    private NodeBT kiri;
    private NodeBT kanan;
    //konstruktor
    public NodeBT(){
        this.data=0; this.kanan=null; this.kiri=null;
    }
    public void setData(int data){ 
        this.data=data;
    }
    public int getData(){ 
        return this.data;
    }
    public void setKiri(NodeBT kiri){
        this.kiri=kiri;
    }
    public NodeBT getKiri(){
        return this.kiri;
    }
    public void setKanan(NodeBT kanan){
        this.kanan=kanan;
    }
    public NodeBT getKanan(){
        return this.kanan;
    }
}
