/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.DictionnaryManager;
import DTO.IoFile;



/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Add Word","Delete Word","Translate","Exit"};
        DictionnaryManager dm = new DictionnaryManager();
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    dm.addWord();
                    break;
                case 2:
                    dm.removeWord();
                    break;
                case 3:
                    dm.translate();
                    break;
                case 4:
                    dm.saveDictionaryToFile();
                    System.exit(0);
            }
        } while (true);
    }
}
