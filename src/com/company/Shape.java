package com.company;

public class Shape {
    private int width,height;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
class qu{
    public static void main(String[] args) {
        Shape oval= new Shape();
        oval.setHeight(100);
        oval.setWidth(50);
        System.out.println("Ширина "+oval.getWidth() +" Высота "+oval.getHeight());
    }
}

