package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class pr22 {
    public static void main(String[] args) {
        Shop s=new Shop();
        HashMap<String, Integer> INNAndFIO = new HashMap<>();
        INNAndFIO.put("Колесников Вадим Вячеславович",555555555);
        Man man=new Man();
        man.pokupka();
        s.zapros();
        String fio=man.FIO();
        s.proverka(man.INN(), INNAndFIO.get(fio));
    }
}
class Shop{
public void zapros(){
    System.out.println("Прошу ваши ФИО и ИНН");
}
public void proverka(int vvodINn, int oldINN){
    if (vvodINn != oldINN){
        throw new IllegalArgumentException("Такой номер ИНН недействителен");
    }
    else{
        System.out.println("Оплата прошла успешно");
    }
}
}
class Man{
public void pokupka(){
    System.out.println("В корзине всё нужное. Пойду оплачу");
}
public String FIO(){
    Scanner in= new Scanner(System.in);
    return in.nextLine();
}
public int INN(){
    Scanner in= new Scanner(System.in);
    return in.nextInt();
}
}

