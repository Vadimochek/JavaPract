package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Student {
public int IDNumber;
public int itog;
Student(){
    IDNumber=(int)(Math.random()*100);
}
Student(int x) {
itog=x;
}
}
class Test{
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        for(int i=0;i<10;i++){
            Student st=new Student();
            array.add(i,st);
        }
        for (int i = 0; i < 10; i++) {
            for (int j=1; j < 10;j++){
                if (array.get(j).IDNumber < array.get(j-1).IDNumber){
                    int temp = array.get(j).IDNumber;
                    array.get(j).IDNumber=array.get(j-1).IDNumber;
                    array.get(j-1).IDNumber=temp;
                }
            }
        }
        for(int i=0;i<10;i++){
            System.out.println(array.get(i).IDNumber);
        }
    }
}
class  SortingStudentsByGPA implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o2.itog, o1.itog);
    }

    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        for(int i=0;i<10;i++){
            Student st=new Student((int)(Math.random()*10));
            array.add(i,st);
        }
        array.sort(new SortingStudentsByGPA());
        for(Student s : array){
            System.out.println(s.itog);
        }
    }
}

