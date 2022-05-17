package ru.gb.mandrik;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 3),
                new Cat("Murzik", 1),
                new Cat("Tom", 6),
                new Cat("Markiz", 8)};
        Plate plate = new Plate(25);
        System.out.println(plate);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
        plate.addEat(20);
        System.out.println(plate);
    }
}
