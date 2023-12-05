/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuant
 */
public class PersonManager {
    Validation validation = new Validation();

    Person[] person;
    public PersonManager() {
        person = new Person[3];
    }

    public void inputPersonInfor() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Input Information of Person");
            String name = validation.getStr("Enter name: ");
            String address = validation.getStr("Enter address: ");
            double salary = validation.getSalary();
            person[i] = inputPersonInfo(name, address, salary);
        }
    }

    public Person inputPersonInfo(String name, String address, double salary) {
        Person person = new Person(name, address, salary);
        return person;
    }

    public void sort() {
        //Collections.sort(list);
        try {
            sortBySalary(this.person);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    Person[] sortBySalary(Person[] person) throws Exception {
        if (person.length == 0) {
            throw new Exception("No information to display!");
        }
        if (person == null) {
            throw new Exception("Can not sort and display null list");
        }
        for (int i = 0; i < 3-1; i++) {
            for (int j = 0; j < 3 - i - 1; j++) {
                if (person[j].getSalary() > person[j+1].getSalary()) {
                    Person temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }
        }
        return person;
    }

    public void displayPersonInfor() {
        sort();
        for(int i = 0 ; i< 3 ; i++){
            displayPersonInfo(person[i]);
        }
    }

    
    public void displayPersonInfo(Person person) {
        System.out.println("Information of Person you have entered:");
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Salary: " + person.getSalary());
    }
}
