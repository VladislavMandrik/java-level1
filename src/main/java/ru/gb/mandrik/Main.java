package ru.gb.mandrik;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkNumbers(-2, 6));
    }

    public static String checkNumbers(int a, int b) {
        if (a + b > 10 && a + b <= 20) {
            return "true";
        } else {
            return "false";
        }
    }
}
