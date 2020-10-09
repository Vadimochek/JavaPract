package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bild extends JFrame {
    public Bild () {
        JButton jb=new JButton();
        setTitle ("Рисование");
        setLayout(new FlowLayout());
        setSize (new Dimension (1000, 1000));
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible (true);
        add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    setVisible (false);
                    setVisible (true);
                }catch (Exception f){
                    f.getMessage();
                }
            }
        });
    }
    public void paint(Graphics g) {
        super.paint(g);
        BildShape shape;
    Graphics2D graph = (Graphics2D) g;
    graph.setStroke(new BasicStroke(10));
        for (int i = 0; i < 20; i++) {
            int b = (int) (Math.random() * 3);
            shape = switch (b) {
                case 0 -> new BildTre();
                case 1 -> new BildRect();
                case 2 -> new BildCircle();
                default -> throw new IllegalStateException("Unexpected value: " + b);
            };
            shape.paint(g);
        }
    }



    public static void main (String [] args) {
        new Bild();
    }
}
