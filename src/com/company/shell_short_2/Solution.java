package com.company.shell_short_2;

public class Solution {
}

class ShellShort {
    int[] numberArr;
    private int gap, gapModifier;
    int swap;

    ShellShort(int n, int gap, int gapMod) {
        numberArr = new int[n];
        this.gap = gap;
        this.gapModifier = gapMod;
    }

    void sort() {
        while (!isSorted()) {
            for (int i = 0; i < numberArr.length; i++) {
                if((i+swap) > (numberArr.length-1)) break;
            }
        }
    }

    boolean isSorted() {
        for (int i = 0; i < numberArr.length; i++) {
            if (i == numberArr.length - 1) break;
            if (numberArr[i] > numberArr[i + 1]) return false;
        }
        return true;
    }
}
