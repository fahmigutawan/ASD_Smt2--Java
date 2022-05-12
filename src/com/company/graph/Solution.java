package com.company.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        var p = new Graph();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            p.insert(scanner.next(), scanner.next());
        }

        System.out.println(p.calculateFirstVertex());
    }
}

class Graph {
    class Vertex {
        Vertex next;
        String data;

        Vertex(String data) {
            this.data = data;
        }
    }

    Vertex head;
    ArrayList<Vertex> branchedVertex = new ArrayList();

    void insert(String parentData, String nextData) {
        if (head == null) {
            head = new Vertex(parentData);
            head.next = new Vertex(nextData);
        } else if (isParentAppear(parentData, nextData)) {
            var tmp = new Vertex(parentData);
            tmp.next = new Vertex(nextData);

            branchedVertex.add(tmp);
        } else {
            Vertex tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Vertex(nextData);
        }
    }

    int calculateFirstVertex() {
        int result = 0;

        if (head != null) {
            /** cek jalur vertex utama terlebih dahulu **/
            //[START]
            if (head.next != null) {
                result += 1;
            }
            //[END]

            /** cek jalur yang memiliki percabangan **/
            //[START]
            var parentData = head.data;
            for (Vertex item : branchedVertex) {
                if (item.data == parentData) {
                    if (item.next != null) {
                        result += 1;
                    }
                }else if(item.next.data == parentData){
                    result+=1;
                }
            }
            //[END]
        }

        return result;
    }

    int calculateSecondVertex() {
        int result = 0;

        if (head != null) {
            /** cek jalur vertex utama terlebih dahulu **/
            //[START]
            if (head.next != null) {
                if (head.next.next != null) {
                    result += 1;
                }
            }
            //[END]

            /** cek jalur yang memiliki percabangan **/
            //[START]
            var parentData = head.data;
            for (Vertex item : branchedVertex) {
                if (item.data == parentData) {
                    if (item.next != null) {
                        if (item.next.next != null) {
                            result += 1;
                        }
                    }
                }
            }
            //[END]
        }

        return result;
    }

    boolean isParentAppear(String data, String next) {
        if (head != null) {
            Vertex tmp = head;
            while (tmp != null) {
                if (tmp.next != null) {
                    if (tmp.data.equals(data)) {
                        return true;
                    }else if(tmp.next.data.equals(next)){
                        return true;
                    }
                }
                tmp = tmp.next;
            }
        }
        return false;
    }
}