package com.company;

import java.util.Scanner;

public class Pr21 {
    public static void main(String[] args) {
        Demo de = new Demo();
        Exception2 ex=new Exception2();
        double x=de.exceptionDemo();
        ex.exceptionDemo();
    }
}
class Demo{
    public double exceptionDemo(){
        try {
            return (2 / 0); //Если 2.0/0.0, то ошибки не будет
        }catch (Exception e){ //Выполняется, если появляется исключение
            System.out.println("Деление на 0");
            e.getMessage();
            return 0;
        }finally { //Блок будет выполнен в любом случае
            System.out.println("Все равно появится.");
        }
    }
}
class Exception2{
    public void exceptionDemo() {
    Scanner myScanner = new Scanner( System.in );
    System.out.print( "Enter an integer ");
    String intString = myScanner.next();
    int i = Integer.parseInt(intString);
    System.out.println( 2 / i );
    }
}
