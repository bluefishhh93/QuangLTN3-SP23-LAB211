/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.StringAnalysis;


/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Input string","Show result","Exit"};
        int choice;
        String input="";
        StringAnalysis sa = new StringAnalysis();
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    input = sa.inputString();
                    break;
                case 2:
                    sa.showResult(input);
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
