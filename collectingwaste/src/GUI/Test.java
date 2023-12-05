/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.CollectingWasteManager;



/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Collecting Garbage","Exit"};
        CollectingWasteManager cm = new CollectingWasteManager();
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    cm.CollectingGarbage();
                    break;
                case 2:
                    System.exit(0);
            }
        } while (true);
    }
}
