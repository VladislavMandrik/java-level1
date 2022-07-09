package ru.gb.mandrik;

public class Main {
    public static void main(String[] args) {

        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                "892312312", 30000, 30);
        empArray[1] = new Employee("Ivanov Igor Ivanovich", "Manager", "i@i.by",
                "+375295686512", 1000, 25);
        empArray[2] = new Employee("Petrov Andrey Ivanovich", "Driver", "a@i.by",
                "+375295254212", 1700, 41);
        empArray[3] = new Employee("Andreev Victor Petrovich", "Teacher", "b@r.by",
                "+375295681865", 1500, 45);
        empArray[4] = new Employee("Drozdov Ivan Alexandrovich", "Manager", "fn.by",
                "+375294342512", 1050, 20);

        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i].getAge() > 40) {
                System.out.println(empArray[i]);
            }
        }
    }
}
