package com.company;

public class Circle {
    private int radius;
    private String color;

    public String getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
class CircleTest{
    public static void main(String[] args) {
        Circle oval= new Circle();
        oval.setColor("Красный");
        oval.setRadius(100);
        System.out.println("Радиус = "+oval.getRadius()+"\nЦвет "+oval.getColor());
    }
}
