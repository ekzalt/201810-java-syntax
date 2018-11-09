package com.company;

// в интерфейсе все поля static, все методы public
public interface IPerson {
    String getFirstName();
    String getLastName();

    // в java 8 в интерфейсы добавили дефолтную реализацию методов
    default String getFullName() {
        return "Vasya Pupkin";
    }
}
