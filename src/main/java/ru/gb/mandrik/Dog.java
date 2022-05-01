package ru.gb.mandrik;

public class Dog extends Animal {

    private String name;

    @Override
    public void run(int length) {
        if (length <= 500) {
            System.out.println("Пёс " + name + " пробежал " + length + " метров.");
        } else {
            System.out.println("Пёс " + name + " не может пробежать более 500 метров. Введите другое расстояние!!!");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= 10) {
            System.out.println("Пёс " + name + " проплыл " + length + " метров.");
        } else {
            System.out.println("Пёс " + name + " не может проплыть более 10 метров. Введите другое расстояние!!!");
        }
    }

    public Dog(String name) {
        this.name = name;
    }
}
