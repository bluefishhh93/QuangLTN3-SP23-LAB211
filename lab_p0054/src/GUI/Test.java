/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.Contact;
import DTO.ContactManager;
import java.util.ArrayList;


/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Add a Contact", "Display all Contact","Delete a Contact","Exit"};
        int choice;
        ContactManager cm = new ContactManager();
        Contact ct = null;
        ArrayList<Contact> list = new ArrayList();
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    cm.addContact(list, ct);
                    break;
                case 2:
                    cm.disPlayAll(list);
                    break;
                case 3:
                    cm.deleteContact(list, ct);
                    
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}
