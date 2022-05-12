package com.company.graph_2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        var p = new Graph();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String tmp = scanner.nextLine();
            String[] tmpList = new String[2];
            tmpList = tmp.split(" ");
            p.insert(tmpList[0], tmpList[1]);
        }

        if (scanner.nextLine().contains("1nd")) {
            System.out.println(p.countFirstDegree());
        } else {
            System.out.println(p.countSecondDegree());
        }

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
    ArrayList<Vertex> branchedVertex = new ArrayList<>();
    ArrayList<Vertex> vertices = new ArrayList<>();

    void insert(String recentKey, String nextKey) {
        if (!recentKey.equals(nextKey)) {
            if (head == null) {
                head = new Vertex(recentKey);
                head.next = new Vertex(nextKey);
                vertices.add(head);
            } else if (isDataAppear(recentKey, nextKey)) {
                if (isAppearWithAnotherForm(recentKey, nextKey)) {
                    var tmp = new Vertex(recentKey);
                    tmp.next = new Vertex(nextKey);
                    branchedVertex.add(tmp);
                    vertices.add(tmp);
                }
            } else {
                if (!isAppearWithAnotherForm(recentKey, nextKey)) {
                    var tmp = head;
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = new Vertex(recentKey);
                    tmp.next.next = new Vertex(nextKey);
                    vertices.add(tmp.next);
                }
            }
        }
    }

    boolean isDataAppear(String recentKey, String nextKey) {
        if (head != null) {
            Vertex tmp = head;
            while (tmp != null) {
                if (tmp.next != null) {
                    if (tmp.data.equals(recentKey)) {
                        return true;
                    }
                }

                if (tmp.data.equals(nextKey)) {
                    return true;
                }
                tmp = tmp.next;
            }
        }

        return false;
    }

    boolean isAppearWithAnotherForm(String recentKey, String nextKey) {
        for (Vertex item : vertices) {
            if (item.data.equals(recentKey) && item.next.data.equals(nextKey)) {
                return true;
            } else if (item.data.equals(nextKey) && item.next.data.equals(recentKey)) {
                return true;
            }
        }

        return false;
    }

    boolean isFirstDegree(String nextKey) {
        if (head != null) {
            var headData = head.data;
            for (Vertex item : vertices) {
                if (item.data.equals(headData) && item.next.data.equals(nextKey)) {
                    return true;
                } else if (item.data.equals(nextKey) && item.next.data.equals(headData)) {
                    return true;
                }
            }
        }
        return false;
    }

    Vertex search(String key) {
        for (Vertex item : vertices) {
            if (item.data.equals(key)) {
                return item;
            }
        }
        return null;
    }

    int countFirstDegree() {
        int result = 0;

        if (head != null) {
            /** cek jalur utama terlebih dahulu **/
            //[START]
            if (head.next != null) {
                result++;
            }
            //[END]

            /** cek cabang yang tersedia **/
            //[START]
            var headData = head.data;
            for (Vertex item : branchedVertex) {
                if (Objects.equals(item.data, headData)) {
                    if (item.next != null) {
                        result++;
                    }
                } else if (Objects.equals(item.next.data, headData)) {
                    result++;
                }
            }
            //[END]
        }

        return result;
    }

    int countSecondDegree() {
        int result = 0;

        //[START]
        if (head != null) {
            ArrayList<Vertex> usedVertex = new ArrayList<>();

            for (Vertex item : vertices) {
                var tmpHeadData = item.data;
                var tmpNextData = item.next.data;

                usedVertex.add(item);
                for (int i = 0; i < usedVertex.size(); i++) {
                    if(usedVertex.get(i).data.equals(tmpNextData)){
                        break;
                    }else if(usedVertex.get(i).next.data.equals(tmpHeadData)){
                        break;
                    }
                    if(i == usedVertex.size()-1){
                        if (isFirstDegree(tmpHeadData)) {
                            if (!isFirstDegree(search(tmpHeadData).next.data)) {
                                result++;
                            }

                        } else if (isFirstDegree(tmpNextData)) {
                            if (!isFirstDegree(search(tmpNextData).next.data)) {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        //[END]

        return result;
    }

    void print() {
        for (Vertex item : vertices) {
            System.out.println(item.data + " - " + item.next.data);
        }
    }
}
