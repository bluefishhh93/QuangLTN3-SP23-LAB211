/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.PersonalManager;






/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Add employee(enter: ae)","Add customer(enter: ac)",
            "Display employee information(enter: dae)","Display customer information(enter: dac)",
            "Customer statistics(enter: cs)","Exit(enter: ea)"};
        String choice;
        do {
            PersonalManager pm = new PersonalManager();
            choice = Menu.getChoice(options);
            switch (choice) {
                case "ae":
                    pm.add("ae");
                    break;
                case "ac":
                    pm.add("ac");
                    break;
                case "dae":
                    pm.dislay("dea");
                    break;
                case "dac":
                    pm.dislay("dac");
                    break;
                case "cs":
                    pm.statistics();
                    break;
                case "ea":
                    pm.exit();
            }
        } while (true);
    }
}
