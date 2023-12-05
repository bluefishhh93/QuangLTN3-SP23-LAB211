/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;




/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Add Task","Delete task","Display Task","Exit"};
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    
                    break;
                case 2:
          
                    break;
                    
                case 3:
                    
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}
