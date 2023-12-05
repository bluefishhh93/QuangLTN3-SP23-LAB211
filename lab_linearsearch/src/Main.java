
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Main {
    Scanner sc = new Scanner(System.in);

    //get an random array with lenght n
    private int[] getARandomArray(int n) {
        int arr[] = new int[n];
        Random rd = new Random();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
        }

        return arr;
    }
    //input the lenght of array
    private int inputLength(){
        int n;
        do{
            try {
                System.out.println("Enter number of array:");
                 n = Integer.parseInt(sc.nextLine());
                 if(n>0) return n;
                 else System.out.println("Number of array must larger than 0");
            } catch (Exception e) {
                System.out.println("Invalid Number of array");
            } 
        }while(true);
    }
    //Enter value to search
    private int inputValue(){
            int x;
        do{
            try {
                System.out.println("Enter search value:");
                 x = Integer.parseInt(sc.nextLine());
                 return x;
            } catch (Exception e) {
                System.out.println("Invalid value");
            } 
        }while(true);
    }
    //printing array
    private void printArray(int arr[]){
         System.out.print("The array: [");
        for (int x : arr) {
            System.out.print(x+" ");
        }
        System.out.println("]");
    }
    //Search value by Linear search method
    private void LinearSearch(int array[],int value){
        boolean check = false;
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                System.out.println("Found "+value+" at index: "+i);
                check = true;
            }
        }
        if(!check){
            System.out.println("Not found!");
        }
    }
            
    public static void main(String[] args) {
        Main m = new Main();
        int n = m.inputLength();
        int x = m.inputValue();
        int array[] = m.getARandomArray(n);
        m.printArray(array);
        m.LinearSearch(array, x);
    }
}
