package com.company;

import java.util.Scanner;

public class MovableRectangle implements Movable{
    public int speedX;
    public int speedY;
    public void MovableRec(int x,int y){
        speedX=x;
        speedY=y;
    }
    void Coloring(){
        System.out.println("Красный");
    }
    void Ugol(){
        System.out.println("4 угла");
    }
    void Race(MovablePoint m1, MovablePoint m2){
    if (m1.getSpeedX()==m2.getSpeedX()&&m1.getSpeedY()==m2.getSpeedY())
    {   System.out.println("Скорость одинакова у точек");
        System.out.println("Центр прямогульника находился на момент начала движения - x: "+(speedX-m2.getSpeedX())+" y: "+(speedY-m1.getSpeedY()));}
    else
    System.out.println("Скорость точек не равна");

    }
}
class test{
    public static void main(String[] args) {
        MovablePoint m1=new MovablePoint();
        MovablePoint m2=new MovablePoint();
        MovableRectangle rec=new MovableRectangle();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите начальные координаты первой точки:");
        m1.SetCord(in.nextInt(),in.nextInt());
        System.out.println("Введите начальные координаты второй точки:");
        m2.SetCord(in.nextInt(), in.nextInt());
        System.out.println("Введите конечные координаты первой точки:");
        m1.MovableRec(in.nextInt(),in.nextInt());
        System.out.println("Введите конечные координаты второй точки:");
        m2.MovableRec(in.nextInt(), in.nextInt());
        System.out.println("Введите конечные координаты центра прямоугольника:");
        rec.MovableRec(in.nextInt(),in.nextInt());
        System.out.println("Про треугольник:");
        rec.Coloring();
        rec.Ugol();
        System.out.println("Про точки и треугольник:");
        rec.Race(m1,m2);
    }
}

