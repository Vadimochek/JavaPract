package com.company;

public class Square {
    private int width;
    String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    void Coloring(){
        System.out.println("Зеленый");
    }
    void Ugol(){
        System.out.println("4 угла");
    }
}
