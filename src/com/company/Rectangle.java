package com.company;

public class Rectangle extends Shap {
    private int a,b,c;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
    void Coloring(){
        System.out.println("Красный");
    }
    void Ugol(){
        System.out.println("4 угла");
    }

}
