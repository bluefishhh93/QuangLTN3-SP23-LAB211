/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author xuant
 */
public class SalaryManager {

    private ArrayList<Worker> list;
    private ArrayList<SalaryHistory> listSalary;

    public SalaryManager() {
        this.list = new ArrayList<>();
        this.listSalary = new ArrayList<>();
    }

    Validation validation = new Validation();

    public boolean addWorker(Worker worker) throws Exception {
        System.out.println("------------------------Add Worker----------------------------");
        do {
            try {
                worker.setId(validation.isCodeExist(list, validation.getID()));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                worker.setName(validation.getNonBlankStr("Enter Name: "));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                worker.setAge(validation.getWorkerAge());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                worker.setSalary(validation.getWorkerSalary());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                worker.setWorkLocation(validation.getNonBlankStr("Enter work location: "));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return list.add(worker);
    }

    public void changeSalary(SalaryStatus status) {
        System.out.println("------------------------Up/Down Salary-----------------------------");
        String code;
        float salary;
        do {
            try {
                code = validation.getID();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                salary = validation.getWorkerSalary();
                break;
            } catch (Exception e) {
            }
        } while (true);

        changeSalary(status, code, salary);
    }

    public boolean changeSalary(SalaryStatus status, String code, float amount) {
        String date = validation.getDate();
        Worker worker = validation.findWorker(list, code.toUpperCase());
        if (worker == null) {
            System.out.println("Not Found!");
            return false;
        }
        if (amount > worker.getSalary() && status == SalaryStatus.DOWN) {
            System.out.println("Amout to decrease can not larger than salary ");
            return false;
        }
        switch (status) {
            case UP:
                worker.setSalary(worker.getSalary() + amount);
                return listSalary.add(new SalaryHistory(code, worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation(), SalaryStatus.UP.toString(), date));
            case DOWN:
                worker.setSalary(worker.getSalary() - amount);
                return listSalary.add(new SalaryHistory(code, worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation(), SalaryStatus.DOWN.toString(), date));
        }
        return false;
    }

    public ArrayList<SalaryHistory> getInfomationSalary() {
        if (listSalary.isEmpty()) {
            System.out.println("There are no information to display");
            return listSalary;
        }
        Collections.sort(listSalary);
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-10s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (SalaryHistory x : listSalary) {
            x.display();
        }
        return listSalary;
    }
}
