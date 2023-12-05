/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;
import java.util.function.BinaryOperator;

/**
 *
 * @author xuant
 */

enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, EXPONENT, EQUAL, INVALID
}

enum BMI {
    UNDERWEIGHT, STANDARD, OVERWEIGHT, FAT, VERYFAT
}

public class Calculator {

    private Scanner sc = new Scanner(System.in);
    
//    Operator checkOperator(String operator) {
//        switch (operator) {
//            case "+":
//                return Operator.ADD;
//            case "-":
//                return Operator.SUBTRACT;
//            case "*":
//                return Operator.MULTIPLY;
//            case "/":
//                return Operator.DIVIDE;
//            case "^":
//                return Operator.EXPONENT;
//            case "=":
//                return Operator.EQUAL;
//            default:
//                return Operator.INVALID;
//        }
//    }
    
    public double calculate (double a, Operator operator, double b){
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            case EXPONENT:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
    
    
    public BMI calculateBMI (double weight, double height){
        double bmi = weight / (Math.pow(height / 100, 2));
        if (bmi < 19) {
            return BMI.UNDERWEIGHT;
        } else if (bmi >= 19 && bmi <= 25) {
            return BMI.STANDARD;
        } else if (bmi > 25 && bmi <= 30) {
            return BMI.OVERWEIGHT;
        } else if (bmi > 30 && bmi <= 40) {
            return BMI.FAT;
        } else {
            return BMI.VERYFAT;
        }
    }
    
   public void normalCalculator(){
        boolean check = false;
        double memory=0;
        System.out.println("----- BMI Calculator -----");
        
        System.out.print("Enter number:");
        double a = Validation.checkin(sc.nextLine());
        System.out.print("Enter operator:");
        Operator operator = Validation.checkOperator(sc.nextLine());
        if(operator==Operator.EQUAL && check == false){
            System.out.println("Result: No result");
            return;
        }
        System.out.print("Enter number: ");
        double b =Validation.checkin(sc.nextLine());      
              
//        if(operator!=Operator.EQUAL){
//                memory = calculate(a, operator, b);
//                check = true;
//                System.out.println("memory: "+memory);
//        }else
//                System.out.println("Result: "+memory);
//            }
        memory = calculate(a, operator, b);
        check = true;
        System.out.println("Memory: "+memory); 
        do{
            System.out.print("Enter operator:");
            operator = Validation.checkOperator(sc.next());
            if(operator==Operator.EQUAL && check == true){
            System.out.println("Result: "+memory);
            return;
        }
            System.out.print("Enter number: ");
            b = Validation.checkin(sc.nextLine());
            memory = calculate(memory, operator, b);
            System.out.println("Memory: "+memory);
            if(operator==Operator.EQUAL)
                System.out.println("Result: "+memory);
        }while(operator!=Operator.EQUAL);
        
    
   }
   public void bmiCalculator(){
       System.out.println("----- BMI Calculator -----");
        System.out.println("Enter weight:");
        double weight = Validation.checkin(sc.nextLine());
        System.out.println("Enter height:");
        double height = Validation.checkin(sc.nextLine());
        System.out.printf("BMI number: %3.2f\n",weight / (Math.pow(height / 100, 2)));
        System.out.println("BMI Status: " + calculateBMI(weight, height));
    }
    
}
