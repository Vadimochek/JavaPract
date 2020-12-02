package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class pr25 {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner in=new Scanner(System.in);
        //1 задание
        System.out.println("Введите дату рождения в формате день.месяц.год");
        Students st=new Students();
        System.out.println("Как хотите вывести дату? (коротко, средне, длинно)");
        System.out.println(st.toString(in.nextLine()));
        //2 задание

        System.out.println("Введите данные <Год><Месяц><Число> <Часы1><минуты>");
        trans();
        // Задание 3
        work();
    }
    static void trans() throws ParseException {
        Scanner in=new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
        String q="";
        for(int i=0;i<3;i++) {
            if( i==2)
                q += in.nextLine();
            else
                q+=in.nextLine()+".";
        }
        Date date = sdf1.parse(q);
        System.out.println(date);
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR, in.nextInt());
        calendar.set(Calendar.MINUTE, in.nextInt());
        System.out.println(sdf2.format(calendar.getTime()));
    }

    public static void work() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date d=sdf.parse("13-11-2020 09:00");
        System.out.println("Колесников Вадим получил задание "+ sdf.format(d));
        Date d2 = new Date();
        System.out.println("Колесников Вадим выполнил задание "+ sdf.format(d2));
    }
}


class Students {
    public int IDNumber;
    public String fio;
    public int itog;
    Date date;

    Students() throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        date = sdf.parse(br.readLine());
    }

    public String toString(String q) {
        switch (q) {
            case "коротко":
                SimpleDateFormat formater1 = new SimpleDateFormat("d/MM/yy");
                return formater1.format(date);
            case "средне":
                SimpleDateFormat formater2 = new SimpleDateFormat("dd/MMM/yyyy");
                return formater2.format(date);
            case "длинно":
                SimpleDateFormat formater3 = new SimpleDateFormat("dd/MMMM/yyyy/G");
                return formater3.format(date);
            default:
                break;
        }
        return null;
    }
}
