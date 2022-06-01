package com.company.hash_table;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable myHash = new HashTable();

        //membuat hastable dengan jumlah 11
        for (int i = 0; i <= 10; i++) {
            myHash.newTable(i);
        }

        //input scanner
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            int asciiValue = 0;

            //forloop untuk konversi character per huruf menjadi ASCII
            for (int j = 0; j < word.length(); j++) {
                asciiValue += word.charAt(j);
            }

            //sesuai ketentuan, key berasal dari asciiValue % 11
            int key = asciiValue % 11;

            myHash.put(key, word);
        }

        myHash.print();
    }
}

class Entry {
    String value;

    public Entry(String value) {
        this.value = value;
    }
}

class HashTable {
    ArrayList<Table> myTable = new ArrayList<>();

    void newTable(int key) {
        //Jika table berjumlah nol
        if (myTable.size() == 0) myTable.add(new Table(key));

        //Jika table tidak nol, maka akan dicek apakah ada key yang sama. Jika ada, maka tidak perlu menambah lagi table baru.
        for (int i = 0; i < myTable.size(); i++) {
            if (myTable.get(i).key == key) break;

            if (i == myTable.size() - 1) myTable.add(new Table(key));
        }
    }

    void put(int key, String value) {
        Table tmp = null;

        for (int i = 0; i < myTable.size(); i++) {
            //Cek terlebih dahulu apakah ada key yang sama.
            //Jika ada, maka tinggal tambah entry baru pada table. Tidak perlu membuat table baru
            if (myTable.get(i).key == key) {
                tmp = myTable.get(i);
                break;
            }

            //Jika ternyata key tidak ada, maka membuat table baru untuk kemudian diulangi lagi
            if (i == myTable.size() - 1) {
                newTable(key);
                put(key, value);
            }
        }

        if (tmp != null) tmp.myEntry.add(new Entry(value));
    }

    void print() {
        for (Table item : myTable) {
            System.out.printf("[%d]", item.key);

            //for loop untuk print isi dari table
            for (Entry tableEntry : item.myEntry) {
                System.out.printf(" -> [%s]", tableEntry.value);
            }

            System.out.println();
        }
    }
}

class Table {
    int key;
    ArrayList<Entry> myEntry = new ArrayList<>();

    public Table(int key) {
        this.key = key;
    }
}
