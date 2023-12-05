/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.LoginSystem;



/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Vietnamese","English","Exit"};
        LoginSystem ls;
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    ls = new LoginSystem("src\\Vi.properties");
                    ls.login();
                    break;
                case 2:
                    ls = new LoginSystem("src\\En.properties");
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
