/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt5;

/**
 *
 * @author HP
 */
 
import java.util.Scanner;
public class Bt5 {
    public static void avScore(){
        Scanner input=new Scanner(System.in);
        String ten;
        double diem;
        System.out.print("Nhap ten: ");
        ten=input.nextLine();
        System.out.print("Nhap diem: ");
        diem=input.nextDouble();
        System.out.print("<<"+ten+">>"+"<<"+diem+">>");
    }
    public static void rectangle(){
        Scanner input=new Scanner(System.in);
    System.out.print("Enter the first side of the rectangle: ");
    double d1 = input.nextDouble();
    System.out.print("Enter the second side of the rectangle: ");
    double d2= input.nextDouble();
    System.out.println("Perimeter = "+(d1+d2)/2);
    System.out.println("Area ="+(d1*d2));
    System.out.println("Minor sides of a rectangle = "+(Math.sqrt(d1*d1+d2*d2)));
    }
    public static void eBill(){
         Scanner input =new Scanner(System.in);
    System.out.print("The number of electric: ");
    int numOfE = input.nextInt();
    if(numOfE<50){
        System.out.print("The bill is "+(numOfE*1000)); 
    }
    if(numOfE>50){
        System.out.print("The bill is "+(numOfE*1200));
     }
    }
    public static void isPrime(){
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
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        boolean check=true;
        do{
        System.out.println("Menu:");
        System.out.println("1-Average score");
        System.out.println("2-Rectangle");
        System.out.println("3-Electricity bill");
        System.out.println("4-Check prime number");
        System.out.println("5-Quit");
        System.out.print("Choose one: ");
        int select=input.nextInt();
        switch(select){
            case 1:
                avScore();
                break;
            case 2:
                rectangle();
                break;
            case 3:
                eBill();
                break;
            case 4:
                isPrime();
                break;
            case 5:
                check=false;
                System.out.println("Exited");
                break;
        }
        }while(check);
        
    }
    
}
