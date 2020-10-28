package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Cards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> igOne = new ArrayList<>();
        ArrayList<Integer> igTwo = new ArrayList<>();
        for (int i=0;i<5;i++){
            igOne.add(in.nextInt());
        }
        for (int i=0;i<5;i++){
            igTwo.add(in.nextInt());
        }
        boolean flag=true;
        for( int i=0;i<106;i++){

            if (igOne.get(0)>igTwo.get(0)){
                if (igOne.get(0)==9 && igTwo.get(0)==0){
                    igTwo.add(igOne.get(0));
                    igTwo.add(igTwo.get(0));
                }else {
                    igOne.add(igTwo.get(0));
                    igOne.add(igOne.get(0));
                }
            }
            if (igOne.get(0) < igTwo.get(0)){
                if (igTwo.get(0)==9 && igOne.get(0)==0){
                    igOne.add(igTwo.get(0));
                    igOne.add(igOne.get(0));
                }else {
                    igTwo.add(igOne.get(0));
                    igTwo.add(igTwo.get(0));
                }
            }

            igOne.remove(0);
            igTwo.remove(0);

            if (igTwo.isEmpty()){
                flag=false;
                System.out.println("first "+ (i+1));
                break;
            }
            if (igOne.isEmpty()){
                flag=false;
                System.out.println("second "+ (i+1));
                break;
            }
        }

        if (flag) System.out.println("botva");
    }
}
