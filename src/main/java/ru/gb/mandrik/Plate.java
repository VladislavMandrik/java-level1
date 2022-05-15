package ru.gb.mandrik;

public class Plate {
    private int food;
    private boolean isEnd;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
        } else {
            System.out.println("Мало еды!");
            isEnd = true;
        }
    }

    public void addEat(int food) {
        this.food += food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public void info() {
        System.out.println("plate: " + food);

    }
}

