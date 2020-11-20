package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Student {
public int IDNumber;
public String fio;
public int itog;
Student(String fio, int x){
    IDNumber=(int)(Math.random()*100);
    this.fio=fio;
    itog=x;
}
}
class Test{
    public static void main(String[] args) {
        new GUI();
    }
}
class  SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o2.itog, o1.itog);
    }

}
class GUI extends JFrame implements Sortirovka {
    public GUI() {
        ArrayList<Student> array = new ArrayList<>();
        for(int i=0;i<10;i++){
            Student st=new Student("Колесников Вадим Вячеславович"+i,(int)(Math.random()*10));
            array.add(i,st);
        }
        setTitle("Интерфейс");
        setLayout(new GridLayout());
        setSize(new Dimension(1000, 1000));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        JPanel container = new JPanel();
        JButton jb1 = new JButton("Сортировка");
        JButton jb2 = new JButton("Поиск");
        container.add(jb1);
        container.add(jb2);
        getContentPane().add(container);
        jb1.addActionListener(e -> {
            try {
                for (int i=0;i<10;i++) {
                    JTextField text = new JTextField(sort(array).get(i).IDNumber+" "+sort(array).get(i).fio+" "+sort(array).get(i).itog);
                    container.add(text);
                    getContentPane().add(container);
                }
            } catch (Exception f) {
                f.getMessage();
            }
        });
        JTextField text = new JTextField("Введите ФИО");
        container.add(text);
        getContentPane().add(container);
        jb2.addActionListener(e -> {
            try {
                if(find(text.getText(),array)>0){
                    text.setText("ID: "+Integer.toString(array.get(find(text.getText(),array)).IDNumber));
                }
                else text.setText("Ошибка, студента нет");
            } catch (Exception f) {
                f.getMessage();
            }
        });
    }

    @Override
    public ArrayList<Student> sort(ArrayList<Student> x)  {
        x.sort(new SortingStudentsByGPA());
        return x;
    }

    @Override
    public int find(String fio, ArrayList<Student> x) {
        for(int i=0;i<10;i++){
            if(fio.equals(x.get(i).fio)) return i;
            if(i==9) {
                throw new IllegalArgumentException("Такого студента нет");
            }
        }
        return 0;
    }
}
interface Sortirovka{
    ArrayList<Student> sort(ArrayList<Student> x);
    int find(String fio,ArrayList<Student> x);
}

