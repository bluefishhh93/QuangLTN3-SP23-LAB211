
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static void countWords(String inputString) {
        // Splitting inputString into words
        String[] words = inputString.split(" ");

        // Creating one HashMap with words as key and their count as value
        Map< String, Integer> wordCount = new HashMap< String, Integer>();

        // Checking each word
        for (String word : words) {
            // whether it is present in wordCount
            if (wordCount.containsKey(word)) {
                // If it is present, incrementing it's count by 1
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                // If it is not present, put that word into wordCount with 1 as
                // it's value
                wordCount.put(word, 1);
            }
        }


        System.out.println(wordCount);
    }

    private static void countLetters(String inputString) {

        Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
        //Converting inputString to char array
        char[] charArray = inputString.toCharArray();

        //traversal of each Character of charArray
        for (char c : charArray) {
            if (letterCount.containsKey(c)) {
                //If char is present in eachCharCountMap, increment count by 1
                letterCount.put(c, letterCount.get(c) + 1);
            } else {                //If char is not present in eachCharCountMap,
                //Putting this char to eachCharCountMap with 1 as it's initial value

                letterCount.put(c, 1);
            }
        }

        //Showing the eachCharCountMap
        letterCount.remove(" ");
        System.out.println(letterCount);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        countWords(st);
        System.out.println();
        countLetters(st);

    }
}

