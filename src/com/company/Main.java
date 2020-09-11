package com.company;

public class Main {

    public static void main(String[] args) {
	int[] arr=new int[10];
	int S=0,S1=0,S2=0,j=0;
	for (int i=0;i<10;i++){
	    arr[i]=(int)(Math.random()*100);
	    S+=arr[i];
    }
	int i=0;
	while(i<10){
		S1+=arr[i];
		i++;
	}
	do{
		S2+=arr[j];
		j++;
	}while (j<10);
        System.out.println(S);
		System.out.println(S1);
		System.out.println(S2);
    }
}
