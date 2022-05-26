package ru.gb.mandrik;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Бобик");
        cat.run(201);
        dog.run(250);
        dog.swim(10);

        System.out.println("Создано животных: " + Animal.getCount());
    }
}
