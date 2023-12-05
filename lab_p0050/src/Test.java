
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Test {
    public static void main(String[] args) {
        String[] options = {"Calculate Superlative Equation","Calculate Quadratic Equation","Exit"};
        int choice;
        float a,b,c;
        Calculate cl = new Calculate();
        List<Float> myList = new ArrayList<>();
        do{
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    System.out.println("----- Calculate Equation -----");
                    a=checkin('A');
                    b=checkin('B');
                    myList=cl.calculateEquation(a, b);                
                    if(myList==null)
                        System.out.println("Solution: no solution");
                    else
                        if(myList.size()==0)
                            System.out.println("Solution: infinitely many solutions");
                        else{
                            System.out.println("Solution: x = "+myList.get(0));
                            //printodd
                            printOdd(myList);
                            printEven(myList);
                            printPerfectSquare(myList);                        
                        }
                    break;
                case 2:
                    System.out.println("----- Calculate Quadratic Equation -----");
                    a=checkin('A');
                    b=checkin('B');
                    c=checkin('C');
                    myList=cl.calculateQuadraticEquation(a, b, c);
                    if(myList==null)
                        System.out.println("Solution: no solution");
                    else
                        if(myList.size()==0)
                            System.out.println("Solution: infinitely many solutions");
                        else{
                            System.out.println("Solution: x1 = "+myList.get(0)+" and x2 = "+myList.get(1));
                            //printodd
                            printOdd(myList);
                            printEven(myList);
                            printPerfectSquare(myList);                        
                        }
                    break;
                case 3:
                    System.exit(0);
            }
        }while(true);
    }
    
    public static float checkin(char x){
        Scanner sc = new Scanner(System.in);
        float number=0;
        do{
        try {
            System.out.print("Enter "+x+':');
            number = Float.parseFloat(sc.nextLine());
            return number;
        } catch (Exception e) {
            System.out.println("Please input number");

        }
        }while(true);
        
    }
    
    public static boolean isOdd(float x){
        if(x % 2 == 1||x%1!=0)
            return true;
        else
            return false;    
    }
    
    public static boolean isEven(float x){
        if(x % 2 ==0&&x%1==0)
            return true;
        else
            return false;    
    }
    
    public static boolean isPerfectSquare(float x){
        if(x>=0){
            int sr = (int)Math.sqrt(x);
            return (sr*sr==x);
        }
        return false;
    }
    
    public static void printOdd(List<Float>myList){
        String separator = "";
        System.out.print("Number is Odd:");
        for (Float x : myList) {
            if(isOdd(x)){
            System.out.print(separator+x);
            separator = ",";
            }
        }
        System.out.println();
    }
    public static void printEven(List<Float>myList){
        String separator = "";
        System.out.print("Number is Even:");
        for (Float x : myList) {
            if(isEven(x)){
            System.out.print(separator+x);
            separator = ",";
            }
        }
        System.out.println();
    }
    public static void printPerfectSquare(List<Float>myList){
        String separator = "";
        System.out.print("Number is perfect square:");
        for (Float x : myList) {
            if(isPerfectSquare(x)){
            System.out.print(separator+x);
            separator = ",";
            }
        }
        System.out.println();
    }
}
