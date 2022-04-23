package ru.gb.mandrik;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkNumbers(5, 6));
        System.out.println(compareNumber(6));
        System.out.println(compareNumberWithBoolean(-3));
        print("Hello", 8);
    }

    public static boolean checkNumbers(int a, int b) {
        if (a + b > 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static String compareNumber(int a) {
        if (a >= 0) {
            return "Положительное";
        } else {
            return "Отрицательное";
        }
    }

    public static boolean compareNumberWithBoolean(int a) {
        if (a >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void print(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }
}