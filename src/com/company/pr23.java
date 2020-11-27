package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class pr23<Temp> {
    ArrayList<Temp> array = new ArrayList<>();

    ArrayList<Temp> translate(Temp[] mas) {
        ArrayList<Temp> list = new ArrayList<>(Arrays.asList(mas));
        for (Temp e : list) {
            System.out.println(e);
        }
        return list;
    }

    public void storage(Temp x) {
        array.add(x);
    }

    public Temp out(int x) {
        return array.get(x);
    }

    void first5(File path) {
        int i = 0;
        ArrayList<File> list = new ArrayList<>();
        if (path.isDirectory()) {
            for (File item : path.listFiles()) {
                if (i < 5) {
                    list.add(item);
                    System.out.println(list.get(i));
                    i++;

                }
            }
        }
    }

}
class Solution<Temp>{
    void newArrayList(Temp value){
        ArrayList<Temp> ar = new ArrayList<>();
        ar.add(value);
    }
    void newHashMap(Temp key, Temp value){
        HashMap<Temp,Temp> hash=new HashMap<>();
        hash.put(key,value);
    }
    void newHashSet(Temp value){
        HashSet<Temp> set =new HashSet<>();
        set.add(value);
    }

}
class Tes{
    public static void main(String[] args) {
        //Задание 1
        pr23<Integer> clas1 = new pr23<>();
        Integer[] mas1 = {5, 7, 9, 10, 11};
        clas1.translate(mas1);
        pr23<String> clas2 = new pr23<>();
        String[] mas2 = {"sqsq", "qsq", "sre", "srq", "dsdsa"};
        clas2.translate(mas2);
        //Задание 2
        clas1.storage(51);
        clas2.storage("hranenie");
        pr23<Double> clas3 = new pr23<>();
        clas3.storage(2.4);
        //Задание 3
        System.out.println(clas1.out(0) + " " + clas2.out(0) + " " + clas3.out(0));
        //Задание 4
        File path = new File("C:\\Users\\vadim\\.AndroidStudio3.5\\system\\log");
        clas1.first5(path);
        //Задание 5 в классе  Solution
        Solution<Integer> sol = new Solution<>();
        sol.newArrayList(5);
        sol.newHashMap(1,55);
        sol.newHashSet(10);
        Solution<String> sol2 = new Solution<>();
        sol2.newArrayList("stro4ka");
        sol2.newHashMap("1","Zapis'");
        sol2.newHashSet("new");
    }
}
