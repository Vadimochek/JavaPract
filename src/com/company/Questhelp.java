package com.company;

import javax.swing.*;
import java.awt.*;


public class Questhelp extends JFrame {

    Questhelp(int p, int k){

        GridBagLayout gridLayout = new GridBagLayout();
        setLayout(gridLayout);
        Container container = getContentPane();
        setLocation(1000,300);
        setSize(400,200);

        GridBagConstraints c = new GridBagConstraints();
        JButton jButton = new JButton("Ещё одна попытка");

        JLabel label = new JLabel();

        switch (k) {
            case 0 -> label.setText("Не угадали. Бери число меньше. Осталось попыток: " + p);
            case 1 -> label.setText("Не угадали. Бери число больше. Осталось попыток: " + p);
            default -> {
                jButton.setText("Завершить игру");
                label.setText("К сожалению, WASTED (проигрыш)! Число - " + k);
            }
            case 3 -> {
                jButton.setText("Завершить игру");
                label.setText("Поздравляю! Вы выиграли!");
            }
        }



        c.gridy = 0;
        container.add(label,c);
        c.gridy = 1;
        container.add(Box.createVerticalStrut(10),c);
        c.gridy = 2;
        container.add(jButton,c);

        jButton.addActionListener(actionEvent -> {
            switch (k) {
                case 0, 1 -> setVisible(false);
                case 2, 3 -> System.exit(0);
            }
        });

        setVisible(true);
    }

}
