package ru.gb.mandrik;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Murzik", 8),
                new Cat("Tom", 6),
                new Cat("Markiz", 8)};
        Plate plate = new Plate(25);
        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        plate.info();
        plate.addEat(20);
        plate.info();
    }
}
