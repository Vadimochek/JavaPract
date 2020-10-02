package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bild extends JFrame {
    JButton jb=new JButton();
    public Bild () {
        setTitle ("Рисование");
        add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        try{

        }catch (Exception f){
            f.getMessage();
        }
            }
        });
        setLayout(new FlowLayout());
        setSize (new Dimension (1000, 1000));
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible (true);
    }
    public void paint(Graphics g) {
        super.paint(g);
        BildShape shape;

        Graphics2D graph = (Graphics2D) g;
        graph.setStroke(new BasicStroke(10));
        for (int i = 0; i < 20; i++) {
            int b = (int) (Math.random() * 3);
            switch (b) {
                case 0:
                    shape = new BildTre();
                    break;
                case 1:
                    shape = new BildRect();
                    break;
                case 2:
                    shape = new BildCircle();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + b);
            }
            shape.paint(g);
        }
    }


    public static void main (String [] args) {
        new Bild();
    }
}
