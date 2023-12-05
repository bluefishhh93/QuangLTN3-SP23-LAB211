/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.BubbleSort;


/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Input Element", "Sort Ascending","Sort Descending","Exit"};
        int choice;
        BubbleSort bs = new BubbleSort();
        int[] arr = null;
       
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    arr=bs.initArray(arr);                   
                    break;
                case 2:
                    bs.display(bs.sortAscending(arr), "->");
                    break;
                case 3:
                    bs.display(bs.sortDescending(arr), "<-");
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}
