package ru.gb.mandrik;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
// task 1
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                a[i] = 0;
            } else {
                a[i] = 1;
            }
            System.out.println(a[i]);
        }
// task 2
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));

// task 3
        int[] b = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < b.length; i++) {
            if (b[i] < 6) {
                b[i] *= 2;
            }
            System.out.println(b[i]);
        }
// task 4
        int[][] c = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    c[i][j] = 1;
                }
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        print(6, 524);
        findMinMax();
    }

    // task 5
    public static void print(int len, int initialValue) {
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = initialValue;
        }
        System.out.println(Arrays.toString(a));
    }

    // task 6
    public static void findMinMax() {
        int[] a = {15, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 25};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("Максимальное значение - " + max);
        System.out.println("Минимальное значение - " + min);
    }
}

