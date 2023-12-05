
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        Main m = new Main();
        int n;
        System.out.print("Enter number of array: ");
        do{
            n= Integer.parseInt(sc.nextLine());
        }while(n<0);
        int[] arr = new int[n];
        arr = m.getARandomArray(arr,n);
        System.out.print("Before sorted: ");
        m.prinArray(arr, n);
        arr = m.buddle_sort(arr);
        System.out.println("After sorted: ");
        m.prinArray(arr, n);
        
        
        
    }
    //Tao mang ngau nhien
    private  int[] getARandomArray(int[] arr,int n)
    {
        Random rd = new Random();
        
        arr= new int[n];
        for(int i =0;i< n; i++){
            arr[i] = rd.nextInt(100);
        }
       
        return arr;
    }
    //sap xep mang
   private int[] buddle_sort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
    
   //in mang
    private  void prinArray(int[] arr, int n){
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
    
   
}

