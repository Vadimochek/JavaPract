package com.company;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Sort {
static int C=0;
    public static void SortUnsorted(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        SortUnsorted(a, lo, mid);
        SortUnsorted(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++) {
            C++;
            buf[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) { C++;
            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            C++;
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                C++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            C++;
            quickSort(array, low, j);
        }

        if (high > i) {
            C++;
            quickSort(array, i, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i=0;i<100;i++){
            arr[i]=(int)(Math.random()*100);
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        long startTime = System.nanoTime();
        SortUnsorted(arr,0,arr.length-1);
        System.out.println("Время "+(System.nanoTime()-startTime)+" нс");
        System.out.println("Сортировка слиянием");
        for (int i=0;i<100;i++){
            System.out.print(arr[i]+" ");
            arr[i]=(int)(Math.random()*100);
        }
        System.out.println();
        System.out.println("Сложность "+C);
        System.out.println("_____________________________");
        C=0;
        startTime = System.nanoTime();
        quickSort(arr,0,arr.length-1);
        System.out.println("Время "+(System.nanoTime()-startTime)+" нс");
        System.out.println("Сортировка быстрая");
        for (int i=0;i<100;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Сложность "+C);
    }
}
