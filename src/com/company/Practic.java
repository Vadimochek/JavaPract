package com.company;

import java.util.Scanner;

public class Practic {
    private static int k=2;
    private static int max = -99999999;
    static int pov=0;
    public static void mno(int n) {
        if (k > n / 2) {
            System.out.println(n);
            return;
        }
        if (n % k == 0) {
            if(pov!=k) {
                pov = k;
                System.out.println(k);
            }
            mno(n / k);
        }
        else {
            k++;
            mno(n);
        }
    }
    public static boolean palindrom(String str) {
        char begin;
        char end;
        int size = str.length();
        String q;
        if (size <= 1) {
            return true;
        } else {
            begin = str.toCharArray()[0];
            end = str.toCharArray()[size - 1];
            q = str.substring(1, size - 1);
            return begin == end && palindrom(q);
        }
    }
    public static int maximum() {
        Scanner in= new Scanner(System.in);
        int posl = in.nextInt();
        if (posl != 0)
            return Math.max(posl, maximum());
        else
            return 0;
    }
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
    mno(in.nextInt());
    if(palindrom(in.next())) System.out.println("Палиндром");
    else System.out.println("Не палиндром");
        System.out.println(maximum());
    }
}
