/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.SalaryManager;
import DTO.SalaryStatus;
import DTO.Worker;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Add a Worker","Increase salary for worker","Decrease salary for worker.","Show adjusted salary worker information.","Exit"};
        int choice;
        SalaryManager sm = new SalaryManager();
        Worker worker = null;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    worker = new Worker();
                {
                    try {
                        sm.addWorker(worker);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                    break;
                case 2:
                    sm.changeSalary(SalaryStatus.UP);
                    break;
                case 3:
                    sm.changeSalary(SalaryStatus.DOWN);
                    break;
                case 4:
                    sm.getInfomationSalary();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
