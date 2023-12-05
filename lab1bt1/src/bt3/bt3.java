/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt3;

/**
 *
 * @author HP
 */
import java.util.Scanner;
public class bt3 {
     public static void main(String[] args){
    Scanner input =new Scanner(System.in);
    System.out.print("The number of electric: ");
    int numOfE = input.nextInt();
    if(numOfE<=50){
        System.out.print("The bill is "+(numOfE*1000)); 
    }
    if(numOfE>50){
        System.out.print("The bill is "+(numOfE*1200));
     }
    
}
}
