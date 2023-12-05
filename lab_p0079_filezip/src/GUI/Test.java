/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.ZipFileSystem;

/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Compression", "Extraction", "Exit"};
        ZipFileSystem zs = new ZipFileSystem();
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    zs.compressTo();
                    break;
                case 2:
                    zs.extracTo();
                    break;

                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
