package ru.gb.mandrik;

public class Plate {
    private int food;
    private boolean isSuccess;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            isSuccess = true;
        } else {
            System.out.println("Мало еды!");
        }
    }

    public void addEat(int food) {
        this.food += food;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}

