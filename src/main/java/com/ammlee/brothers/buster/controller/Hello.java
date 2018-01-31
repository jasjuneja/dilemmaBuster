package com.ammlee.brothers.buster.controller;

public class Hello {


    public static void main(String[] args) {

        int [] arr= new int[]{2, 7, 6, 1, 4, 5};

        int start=0;
        int maxSum =1;

        int sum=0;

        while (start<arr.length){

            sum += arr[start];

            if(sum> maxSum){
                maxSum=sum;
            }



        }



    }
}
