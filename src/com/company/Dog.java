package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dog {
    private String name;
    private int age;
    Dog(String name,int age){
        this.name=name;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    int toHuman(int year){
        return year*7;
    }
    String toString(String n,int a){
        return "Это "+n+" ему "+a;
    }
}
class Pitomnik{
    public static void main(String[] args) {
        List<Dog> pets=new ArrayList<>();
        Dog spitz=new Dog("Pol",3);
        System.out.println(spitz.toString(spitz.getName(),spitz.getAge()));
        System.out.println("Хотите изменить имя и возраст?");
        Scanner in=new Scanner(System.in);
        String q=in.nextLine();
        if(q.equals("Да") || q.equals("да"))
        {
            System.out.println("Введите данные - сначала годы, потом имя");
            int n=in.nextInt();
            spitz.setAge(n);
            String str=in.next();
            spitz.setName(str);
            System.out.println("Вывод данных о собаке");
            System.out.println(spitz.toString(spitz.getName(),spitz.getAge()));
        }
        System.out.println("Переводя на человеческий, собаке лет - "+ spitz.toHuman(spitz.getAge()));
        System.out.println("Добавление собаки в питомник...");
        pets.add(spitz);
    }
}
