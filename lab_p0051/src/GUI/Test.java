/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.Calculator;

/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Normal Calculator", "BMI Calculator","Exit"};
        int choice;
        Calculator ccl = new Calculator();
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    ccl.normalCalculator();
                    break;
                case 2:
                    ccl.bmiCalculator();
                    break;
                case 3:
                    System.exit(0);
                    ;
            }
        } while (true);
    }
}
