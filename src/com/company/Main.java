package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;

public class Main {
	static int factorial(int n) {
		int S = 1;
		while (n > 0) {
			S = S * n;
			n=n-1;
		}
		return S;
	}
    public static void main(String[] args) {
		final Random random = new Random();
		int[] arr = new int[10];
		int[] arr1 = new int[10];
		int S = 0, S1 = 0, S2 = 0, j = 0;
		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 100);
			arr1[i] = random.nextInt(100);
			S += arr[i];
			System.out.print(arr[i] + " ");
		}
		int i = 0;
		System.out.println();
		while (i < 10) {
			S1 += arr[i];
			System.out.print(arr1[i] + " ");
			i++;
		}
		do {
			S2 += arr[j];
			j++;
		} while (j < 10);
		System.out.println();
		Arrays.sort(arr);
		Arrays.sort(arr1);
		System.out.println("for S = "+S);
		System.out.println("while S = "+ S1);
		System.out.println("do while S = " +S2);
		for (int k = 0; k < 10; k++) {
			System.out.print(arr[k]+" ");
		}
		System.out.println();
		for (int k = 0; k < 10; k++) {
			System.out.print(arr1[k]+" ");
		}
		System.out.println();
		System.out.println("5!"+factorial(5));
	}
}
