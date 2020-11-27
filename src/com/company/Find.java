package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Find {
    static int C=0;
    static int BinaryFindIterative(Student[] students, int iFirst, int iLast, int Value){
        int index=0, iMid;
        while (index>-1){
            C++;
            if (iFirst>iLast) {
                index = -1;
            }
            else{
                iMid=(iFirst+iLast)/2;
                if (Value==students[iMid].IDNumber){
                    index=iMid;
                    break;
                }
                else  if (Value<students[iMid].IDNumber)
                    iLast=iMid-1;
                else if(Value>students[iMid].IDNumber)
                    iFirst=iMid+1;
            }
        }
        return index;
    }
    static int BinaryFind(Student[] students, int iFirst, int iLast, int Value){
        int index;
        if (iFirst>iLast) {
            C++;
            index = -1;
        }
        else{
            C++;
            int iMid=(iFirst+iLast)/2;
            if (Value==students[iMid].IDNumber)
                index=iMid;//найдено
            else if(Value<students[iMid].IDNumber)
                index=BinaryFind(students,iFirst,iMid-1,Value);
     else
            index=BinaryFind(students,iMid+1,iLast,Value);
        }
        return index;
    }
    public static int linearSearch(Student[] arr, int Value) {

        for (int index = 0; index < arr.length; index++) {
            C++;
            if (arr[index].IDNumber == Value)
                return index;
        }
        return -1;
    }
    public static int LinearRecSearch(Student[] numbers, int key,int i) {
        C++;
        int pos = -1;
        if (numbers[i].IDNumber == key) {
            pos = i;
            return pos;
        }
        if (i < numbers.length - 1)
        LinearRecSearch(numbers, key, i + 1);
        return pos;
    }
    public static void quickSort(Student[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int opora = array[middle].IDNumber;

        int i = low, j = high;
        while (i <= j) {
            while (array[i].IDNumber < opora) {
                i++;
            }

            while (array[j].IDNumber > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i].IDNumber;
                array[i] = array[j];
                array[j].IDNumber = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j) {
            quickSort(array, low, j);
        }

        if (high > i) {
            quickSort(array, i, high);
        }
    }
    public static void main(String[] args) {
        Student[] ar=new Student[20];
        for(int i=0;i<20;i++){
            ar[i]= new Student("dfd",10);
        }
        System.out.println("Хотим найти значение ID=10 ");
        long startTime = System.nanoTime();
        int z=linearSearch(ar,10);
        System.out.println("Время "+(System.nanoTime()-startTime)+" нс");
        if (z>-1) System.out.println("Индекс элемента "+z);
        else System.out.println(" 10 id не найден");
        System.out.println("Сложность "+C);
        C=0;

        startTime = System.nanoTime();
        int k=LinearRecSearch(ar,10,0);
        System.out.println("Время "+(System.nanoTime()-startTime)+" нс");
        if (k>-1) System.out.println("Индекс элемента "+k);
        else System.out.println(" 10 id не найден");
        System.out.println("Сложность "+C);
        C=0;
        quickSort(ar,0,ar.length-1);
        startTime = System.nanoTime();
        int x=BinaryFind(ar,0,ar.length-1,10);
        System.out.println("Время "+(System.nanoTime()-startTime)+" нс");
        if (x>-1) System.out.println("Индекс элемента "+x);
        else System.out.println(" 10 id не найден");
        System.out.println("Сложность "+C);
        C=0;

        startTime = System.nanoTime();
        int y=BinaryFindIterative(ar,0,ar.length-1,10);
        System.out.println("Время "+(System.nanoTime()-startTime)+" нс");
        if (y>-1) System.out.println("Индекс элемента "+y);
        else System.out.println(" 10 id не найден");
        System.out.println("Сложность "+C);

    }
}
