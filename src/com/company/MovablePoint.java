package com.company;

public class MovablePoint extends MovableRectangle implements Movable {
    int x0,y0;
    public void SetCord(int x, int y){
        x0=x;
        y0=y;
    }
    public void MovableRec(int x, int y){
        speedX=x;
        speedY=y;
    }
    public int getSpeedX() {
        return speedX-x0;
    }
    public int getSpeedY() {
        return speedY-y0;
    }
}
