package com.company;

public class Employee {
    // объявление свойств
    String firstName;
    String lastName;

    // конструктор
    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void work(int hours) {
        System.out.println(getFullName() + " works " + hours + " hours");
    }
}
