package com.company;

import java.util.Scanner;

public class logic {
    public static void digit(int N){
     if(N>0) {
         digit(N / 10);
         System.out.println(N%10);
     }
    }
    public static void summary(int k, int s) {
        int down = (int) (Math.pow(10, k - 1));
        int Schet = 0;
        int up = (int) (Math.pow(10, k));
        while (down != up) {
            int digit = up, sum = 0;
            while (digit != 0) {
                sum += digit % 10;
                digit /= 10;
            }
            if (sum == s) Schet++;
            up--;
        }
        System.out.println("Всего чисел "+Schet);
    }

    public static int fnulls(int nulls, int ones) {
    if(nulls>ones+1)
        return 0;
    if(nulls==0 || ones==0)
        return 1;
    return fnulls(nulls,ones-1)+fnulls(nulls-1,ones-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k;
        do {
            System.out.println("1.Сумма цифр 2.Без двух нулей 3.Цифры числа");
            k = in.nextInt();
            switch (k) {
                case 1 -> summary(in.nextInt(), in.nextInt());
                case 2 -> System.out.println(fnulls(in.nextInt(), in.nextInt()));
                case 3 -> digit(in.nextInt());
                default -> System.out.println("Неправильный выбор.");
            }
        }while(k!=4);
    }
}
