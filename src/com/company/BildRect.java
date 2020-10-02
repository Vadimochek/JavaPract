package com.company;

import java.awt.*;

public class BildRect extends BildShape{
    int r,g,b;
    int x,y,w,h;

    BildRect(){
        setColor();
        setY();
        setX();
    }


    public void setColor() {
        r = (int) (Math.random() * 255);
        b = (int) (Math.random() * 255);
        g = (int) (Math.random() * 255);
    }
    public void setX() {
        x = (int) (Math.random()*700);
        w = (int) (Math.random()*350);
    }

    public void setY() {
        y = (int) (Math.random()*700);
        h = (int) (Math.random()*350);
    }

    public void paint(Graphics g) {
        Graphics2D graph =  (Graphics2D) g;
        graph.setPaint(new Color(r, this.g, b));
        graph.drawRect(x,y,w,h);
    }
}
