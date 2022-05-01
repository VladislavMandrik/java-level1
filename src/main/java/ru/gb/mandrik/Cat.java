package ru.gb.mandrik;

public class Cat extends Animal {

    private String name;

    @Override
    public void run(int length) {
        if (length <= 200) {
            System.out.println("Кот " + name + " пробежал " + length + " метров.");
        } else {
            System.out.println("Кот " + name + " не может пробежать более 200 метров. Введите другое расстояние!!!");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот " + name + " не умеет плавать");
    }

    public Cat(String name) {
        this.name = name;
    }
}

