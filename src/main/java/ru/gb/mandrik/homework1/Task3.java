package ru.gb.mandrik.homework1;

public class Task3 {
    public static void main(String[] args) {
        checkSumSign();
    }

    public static void checkSumSign() {
        int a = 10;
        int b = 15;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Cумма положительная");
        } else {
            System.out.println("Cумма отрицательная");
        }
    }
}

