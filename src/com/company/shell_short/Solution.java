package com.company.shell_short;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static Scanner in = new Scanner(System.in);

    // lakukan increment setiap melakukan swapping di dalam array
    private static int swap = 0;

    public static void main(String[] args) {
        // ukuran dari array
        int size = in.nextInt();

        // instansiasi array yang akan disorting
        int[] unsortedArray = new int[size];

        // mengisi array unsortedArray
        for (int i = 0; i < size; i++) unsortedArray[i] = in.nextInt();

        // nilai gap awal untuk shell sort
        int gap = in.nextInt();

        // pengubah nilai gap
        String gapModifier = in.next();


        // hasil sorting shell sort
        int[] sortedArray = shellSort(unsortedArray, gap, gapModifier);

        // print hasil sorting shell sort
        printArray(sortedArray);

        // print jumlah proses swapping yang terjadi
        System.out.println("\nswap: " + swap);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(",");
        }
    }

    public static int[] shellSort(int[] arr, int gap, String gapModifier) {
        int[] result = arr;

        while (!isSorted(result)) {
            for (int i = 0; i < result.length; i++) {
                if (i + gap > result.length-1) break;

                if(result[i+gap]<result[i]){
                    var tmp = result[i];
                    result[i] = result[i+gap];
                    result[i+gap] = tmp;
                    swap++;
                }
            }

            if (gapModifier.contains(":")) {
                if(getGapMod(gapModifier) >= gap) gap = 1;
                else Math.floor(gap /= getGapMod(gapModifier));
            } else if (gapModifier.contains("-")) {
                if(getGapMod(gapModifier) >= gap) gap = 1;
                else gap -= getGapMod(gapModifier);
            }
        }

        return result;
    }

    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) break;
            if (arr[i] > arr[i + 1]) return false;
        }
        if(arr.length == 1) return true;

        return true;
    }

    static int getGapMod(String gm) {
        String tmp = gm.substring(1);
        return Integer.parseInt(tmp);
    }
}