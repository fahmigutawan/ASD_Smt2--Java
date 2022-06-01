package com.company.search;

import java.util.Scanner;

public class Solution {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int size = in.nextInt();
        char[] arr = new char[size];
        char key = in.next().charAt(0);
        for (int i = 0; i < size; i++) {
            arr[i] = in.next().charAt(0);
        }

        if (binarySearch(key, arr)) System.out.println("Ketemu!");
        else System.out.println("Gaada");
    }

    static boolean binarySearch(char key, char[] arr) {
        //sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        //searching
        boolean isGenap = arr.length % 2 == 0;
        if (isGenap) {
            //jika genap, index yang diambil adalah tengah plus satu.
            //Misal ada 6 element, dibagi dua jadi 3. Index 3 adalah index pertama bagian kanan.
            int index = arr.length / 2;
            if (arr[index] == key) {
                //jika ditemukan pertama kali, sebelum dicari
                return true;

            } else if (arr[index] >= key) {
                //maka cari ke kiri
                for (int i = index; i >= 0; i--) {
                    if (arr[i] == key) return true;
                }

            } else {
                //maka cari ke kanan
                for (int i = index; i < arr.length; i++) {
                    if (arr[i] == key) return true;
                }

            }

        } else {
            //Jika ganjil, length harus dikurangi satu terlebih dahulu agar genap
            //saat dibagi dua, hasilnya pasti tepat bagian tengah. Sehingga lebih mudah
            int index = (arr.length - 1) / 2;
            if (arr[index] == key) {
                //jika ditemukan tepat di tengah
                return true;
            } else if (arr[index + 1] >= key) {
                //jika dicari di kanan
                for (int i = index + 1; i >= 0; i--) {
                    if (arr[i] == key) return true;
                }
            } else {
                //jika dicari di kiri
                for (int i = index - 1; i < arr.length; i++) {
                    if (arr[i] == key) return true;
                }
            }
        }

        return false;
    }
}
