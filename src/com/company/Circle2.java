package com.company;

public class Circle2 extends Shap {
    private int rad;
    String name;

    public String getName() {
        return name;
    }

    public int getRad() {
        return rad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }
    void Coloring(){
        System.out.println("Синий");
    }
    void Ugol(){
        System.out.println("Нет углов");
    }
}
