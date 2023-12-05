/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author xuant
 */
public class BubbleSort {
    Scanner sc = new Scanner(System.in);
    public int[] initArray(int[] arr){
         System.out.println("----- Input Element -----");
         int length = Validation.getLength();
         arr = new int[length];
         Validation.getElement(arr);
         return arr;
     }   
    
    public int[] sortDescending(int[] arrayNeedSort){
         int n = arrayNeedSort.length;
         for(int i=0;i<n-1;i++)
             for(int j=0;j<n-i-1;j++){
                 if(arrayNeedSort[j]<arrayNeedSort[j+1]){
                     int temp = arrayNeedSort[j];
                     arrayNeedSort[j] = arrayNeedSort[j+1];
                     arrayNeedSort[j+1] = temp;
                 }
             }
         System.out.println("----- Descending -----");
         return arrayNeedSort;
     }
     
    public int[] sortAscending(int[] arrayNeedSort){
          int n = arrayNeedSort.length;
         for(int i=0;i<n-1;i++)
             for(int j=0;j<n-i-1;j++){
                 if(arrayNeedSort[j]>arrayNeedSort[j+1]){
                     int temp = arrayNeedSort[j];
                     arrayNeedSort[j] = arrayNeedSort[j+1];
                     arrayNeedSort[j+1] = temp;
                 }
             }
         System.out.println("----- Ascending -----");
         return arrayNeedSort;
     }
     
    public void display(int[] array,String sign){
         String str="";
         for(int i=0; i<array.length;i++){
             System.out.printf(str+"["+array[i]+"]");
             str = sign;
         }
         System.out.println("");
         
     }
}
