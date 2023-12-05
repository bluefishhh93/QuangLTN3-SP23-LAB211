/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author xuant
 */
public class Validation {
    public String inputFilePath() {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("Please input Path: ");
        String result = sc.nextLine().trim();
        if (result.length() == 0) {
            System.err.println("Not empty.");
        } else if (!result.matches("^[a-zA-Z]:\\\\(?:[^\\\\\\/:*?\"<>|\\r\\n]+\\\\)*[^\\\\\\/:*?\"<>|\\r\\n]*$")) {
            System.err.println("Invalid path format. Please enter a valid file path.");
        } else {
            return result;
        }
    }
}
}
