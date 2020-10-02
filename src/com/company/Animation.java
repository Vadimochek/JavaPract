package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class Animation extends JFrame {
    static Image im;
    public Animation() {

        setTitle("Anime");
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        setLayout(new BorderLayout());
        String q = "";
        int i = 0;
        while (true) {
            i = (i + 1) % 32;
            if (i < 10)
                q = "C:/Users/vadim/Downloads/rolling barrel bitmaps/barrel rolling ne000" + i + ".bmp";
            else
                q = "C:/Users/vadim/Downloads/rolling barrel bitmaps/barrel rolling ne00" + i + ".bmp";
            try {
                Thread.sleep(100);
                im = ImageIO.read(new File(q));
                super.paint(g);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            Graphics2D graph=(Graphics2D) g;
            graph.drawImage(im,150,150,null);
        }
    }

    public static void main(String[] args) {
        new Animation();
    }
}
