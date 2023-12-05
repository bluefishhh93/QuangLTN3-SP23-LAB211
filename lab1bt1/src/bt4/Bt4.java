/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt4;

/**
 *
 * @author HP
 */

import java.util.Scanner;
public class Bt4 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter an integer: ");
        double a=input.nextDouble();
        int n=0;
        for(int i=1;i<Math.sqrt(a);i++){
            if(a%i==0) ++n;
        }
        if(n>1){
            System.out.println("This number is not a prime");
        }
        else{
            System.out.println("This number is a prime");
        }
    }
    
}
