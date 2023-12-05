/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt2;

/**
 *
 * @author HP
 */
import java.util.Scanner;
public class bt2 {
    public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    System.out.print("Enter the first side of the rectangle: ");
    double d1 = input.nextDouble();
    System.out.print("Enter the second side of the rectangle: ");
    double d2= input.nextDouble();
    System.out.println("Perimeter = "+(d1+d2)/2);
    System.out.println("Area ="+(d1*d2));
    if(d1>d2)
    System.out.println("Minor sides of a rectangle = "+d2);
    else
        System.out.println("Minor sides of a rectangle = "+d1);
    
    
    
}
}
