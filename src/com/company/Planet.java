package com.company;

import javax.swing.*;
import java.awt.*;


public class Planet extends JFrame {
    public Planet () {
        setTitle ("Планетки");
        setLayout(new GridLayout());
        setSize (new Dimension (1000, 1000));
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible (true);
        JPanel container = new JPanel();
        JTextField text = new JTextField("Гравитация на планете",30);
        for(PlanetEnum en:PlanetEnum.values()) {
            JButton jb=new JButton(en.name());
            container.add(jb);
            jb.addActionListener(e -> {
                try {
                  text.setText((en.gravitation(en.mas,en.rad)));
                } catch (Exception f) {
                    f.getMessage();
                }
            });
            container.add(text);
            getContentPane().add(container);
        }
    }

    public static void main(String[] args) {
        new Planet();
    }
}
