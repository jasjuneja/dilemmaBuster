package com.ammlee.brothers.buster.controller;

public class Test {


    public static void main(String[] args) {
        int[] array = new int[]{3,4,-1,0,6,2,3};
        int[] t= new int[array.length];

        for (int k = 0; k < t.length; k++) {
            t[k]=1;
        }

        int i=1;
        int j=0;

        while (i<array.length){

            if(array[i]>array[j]){
                t[i]= Math.max(t[i],t[j]+1);
                j++;
            }else if(array[i]<=array[j]) {
                j++;
            }
            if(i==j){
                i++;
                j=0;
            }
        }

        for (int k = 0; k <t.length ; k++) {
            System.out.println(t[k]);
        }

    }
}

