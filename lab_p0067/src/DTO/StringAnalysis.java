/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author xuant
 */
public class StringAnalysis {

    HashMap<String, ArrayList<Integer>> numberResult;
    HashMap<String, StringBuilder> characterResult;

    public StringAnalysis() {
        numberResult = new HashMap();
        characterResult = new HashMap();
    }

    public String inputString() {
        System.out.println("-----Result Analysis------");
        System.out.println("Input String: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty() || input.isBlank()) {
            System.out.println("Empty input ");
            return "";
        }
        return input;
    }

    public HashMap<String, ArrayList<Integer>> getNumber(String input) {
        ArrayList<Integer> numberList = new ArrayList();
        ArrayList<Integer> perfectSquareList = new ArrayList();
        ArrayList<Integer> evenList = new ArrayList();
        ArrayList<Integer> oddList = new ArrayList();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            numberList.add(number);
        }

        //get square number
        for (Integer x : numberList) {
            if (Math.sqrt(x) == (int) Math.sqrt(x) * (int) Math.sqrt(x)) {
                perfectSquareList.add(x);
            }
        }
        //get even and odd number
        for (Integer x : numberList) {
            if (x % 2 == 0) {
                evenList.add(x);
            } else {
                oddList.add(x);
            }
        }
        //put arraylists to hashmap
        numberResult.put("Perfect Square Numbers", perfectSquareList);
        numberResult.put("Odd Numbers", oddList);
        numberResult.put("Even Numbers", evenList);
        numberResult.put("All number", numberList);
        return numberResult;
    }

    public HashMap<String, StringBuilder> getCharacter(String input) {
        StringBuilder upperCase = new StringBuilder();
        StringBuilder lowerCase = new StringBuilder();
        StringBuilder special = new StringBuilder();
        StringBuilder allCharacter = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(!Character.isDigit(c)) {
                allCharacter.append(c);
            }
            if (Character.isUpperCase(c)) {
                upperCase.append(c);
            } else if (Character.isLowerCase(c)) {
                lowerCase.append(c);
            } else if (!Character.isLetterOrDigit(c)) {
                special.append(c);
            }
             
            
        }
        
        characterResult.put("Uppercase Characters", upperCase);
        characterResult.put("Lowercase Characters", lowerCase);
        characterResult.put("Special Characters", special);
        characterResult.put("All Character", allCharacter);
        return characterResult;
    }

    public void showResult(String input) {
        if (input.isEmpty() || input.isBlank()) {
            System.out.println("Nothing to show! ");
            return;
        }
        getNumber(input);
        getCharacter(input);
        System.out.println("-----Result Analysis------");
        for (HashMap.Entry<String, ArrayList<Integer>> entry : numberResult.entrySet()) {
            String key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            System.out.print(key + ": ");
            for (Integer x : value) {
                System.out.print(x + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        for (HashMap.Entry<String, StringBuilder> entry : characterResult.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            System.out.println(key + ": " + value);
        }
    }
}
