package com.company;

import javax.swing.*;
import java.awt.*;



public class Quest extends JFrame {

    int tri = 3;

    public Quest(){

        final int r = (int) (Math.random()*20);

        GridBagLayout gridLayout = new GridBagLayout();
        setLayout(gridLayout);
        Container container = getContentPane();
        setLocation(500,300);
        setSize(700,300);

        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel("Загадано число 0 до 20. Угадайте его. Количество попыток осталось: " + tri);
        JTextField jtf = new JTextField(4);
        JButton jButton = new JButton("Сделать выбор");
        jtf.setPreferredSize(new Dimension(0,30));

        c.gridy = 0;
        container.add(label,c);
        c.gridy = 1;
        container.add(Box.createVerticalStrut(10),c);
        c.gridy = 2;
        container.add(jtf,c);
        c.gridy = 3;
        container.add(Box.createVerticalStrut(10),c);
        c.gridy = 4;
        container.add(jButton,c);

        jButton.addActionListener(actionEvent -> {
            int f = Integer.parseInt(jtf.getText());
            if (f>r){
                tri--;
                label.setText("Попробуйте ещё раз. Количество попыток: " + tri);
                if (tri != 0) {
                    new Questhelp(tri, 0);
                }
            }else if(f<r){
                tri--;
                label.setText("Попробуйте ещё раз. Количество попыток: " + tri);
                if (tri != 0) {
                    new Questhelp(tri, 1);
                }
            }else new Questhelp(tri,3);

            if(tri==0){
                new Questhelp(tri,r);
            }
        });

        setVisible(true);
    }


    public static void main(String[] args) {
        new Quest();
    }
}
