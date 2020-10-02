package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class cmd extends JFrame {
    public static String x="";
    cmd(){
        setLayout(new BorderLayout());
        System.out.println(x);
        JLabel background=new JLabel(new ImageIcon(x));
        add(background);
        background.setLayout(new FlowLayout());
        setTitle ("Картинка");
        setSize (new Dimension(1000, 1000));
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible (true);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
    x=in.nextLine();
    new cmd();
    }
}
