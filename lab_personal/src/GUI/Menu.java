/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.Scanner;

/**
 *
 * @author xuant
 */
public class Menu {

    public static String getChoice(Object[] options) {
        String choice = "";
        System.out.println("===== personnel management program ====");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("> Choose: ");
            choice = sc.nextLine().toLowerCase();
            if (choice.equals("ae") || choice.equals("ac") || choice.equals("dae") || choice.equals("dac")
                    || choice.equals("cs") || choice.equals("ea")) {
                break;
            } else {
                System.out.println("Invalid choice!");
                System.out.println("Enter again!");
            }
        } while (true);
        return choice;
    }
}
