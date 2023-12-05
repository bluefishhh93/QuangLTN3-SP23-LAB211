/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.Doctor;
import DTO.DoctorHash;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Add Doctor", "Update Doctor","Delete Doctor","Search Doctor","Exit"};
        int choice;
        DoctorHash dh = new DoctorHash();
        Doctor doctor = null;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                   dh.addDoctor();
                    break;

                case 2:
                {
                    try {
                        dh.updateDoctor(doctor);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                    break;

                case 3:
                {
                    try {
                        dh.deleteDoctor(doctor);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                    break;
                
                case 4:
                    dh.searchDoctor();
                    break;

                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
