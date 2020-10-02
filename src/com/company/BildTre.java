package com.company;

import java.awt.*;

public class BildTre extends BildShape {
    int r,g,b;
    int x1,y1,x2,y2,x3,y3,w,h;

    BildTre(){
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
        x1 = (int) (Math.random()*700);
        x2 = (int) (Math.random()*700);
        x3 = (int) (Math.random()*700);
        w = (int) (Math.random()*350);
    }

    public void setY() {
        y1 = (int) (Math.random()*700);
        y2 = (int) (Math.random()*700);
        y3 = (int) (Math.random()*700);
        h = (int) (Math.random()*350);
    }

    public void paint(Graphics g) {
        Graphics2D gr2d =  (Graphics2D) g;
        gr2d.setPaint(new Color(r, this.g, b));
        Polygon rectangle = new Polygon();
        rectangle.addPoint(x1, y1);
        rectangle.addPoint(x2, y2);
        rectangle.addPoint(x3, y3);

        g.drawPolygon(rectangle);
    }

}
