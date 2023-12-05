/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.ValidateManager;




/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Input information","Show information","Exit"};
        ValidateManager vm = new ValidateManager();
        int choice;
        String phone="", date="", mail="";
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    phone = vm.checkPhone(phone);
                    date = vm.checkDate(date);
                    mail = vm.checkEmail(mail);
                    break;
                case 2:
                    vm.display(phone, date, mail);
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
