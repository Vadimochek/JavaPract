package com.company;

import java.util.Scanner;

public class Uml {

    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        Circle2 circle = new Circle2();
        Square romb = new Square();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите стороны треугольника");
        rec.setA(in.nextInt());
        rec.setB(in.nextInt());
        rec.setC(in.nextInt());
        circle.setName("Круг");
        circle.setRad(20);
        romb.setWidth(50);
        romb.setColor("Синий");
        System.out.println("Вывод всех фигур\n" +
                "Треугольник со сторонами " + rec.getA() + " " + rec.getB() + " " + rec.getC()
                + "\n" + circle.getName() + " с радиусом " + circle.getRad() + "\nКвадрат со стороной " + romb.getWidth() + " цвета " + romb.getColor());
    }
}







