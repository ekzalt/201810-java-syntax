package com.company;

// наследуем абстракный класс
public class ShapeCircle extends ShapeBase {
    // и имплементируем абстакный метод
    public void draw() {
        System.out.println("Shape Circle, color default");
    }

    // перегрузка метода
    public void draw(String color) {
        System.out.println("Shape Circle, color " + color);
    }
}
