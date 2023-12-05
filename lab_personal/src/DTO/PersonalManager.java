/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author xuant
 */
public class PersonalManager {

    ArrayList<Employee> employeesList;
    static int employeNum = 0;
    static int customerNum = 0;
    ArrayList<Customer> customersList;
    Validation validation;

    public PersonalManager() {
        validation = new Validation();
        employeesList = new ArrayList<>();
        customersList = new ArrayList<>();
    }

    
    //ham tu dong tra ve code
    public String getCode(String choice) {
        String code = "";
        if (choice.equals("ae")) {
            code = "e" + employeNum + 1;
        }
        if (choice.equals("ac")) {
            code = "c" + customerNum + 1;
        }

        return code;
    }
    
    
    //them vao danh sach mot employee hoac 1 customer
    public void add(String choice) {
        String name = validation.getNonBlankStr("Enter name: ", "not empty");
        String gender = validation.getGender();
        String birth = validation.getBirth();
        if (choice.equals("ae")) {
            System.out.println("=====================Add employee================");
            String eCode = getCode(choice);
            String degree = validation.getDegree();
            employeesList.add(new Employee(eCode, degree, name, gender, birth));
            employeNum++;
        }
        if (choice.equals("ac")) {
            System.out.println("=====================Add customer===============");
            String cCode = getCode(choice);
            String cType = validation.getCusomterType();
            customersList.add(new Customer(cCode, cType, name, gender, birth));
            customerNum++;
        }
    }

    //hien thi thong tin cua employee hoac customer
    public void dislay(String choice) {
        if (choice.equals("dae")) {
            System.out.printf(("%-10s %-10s %-10s %-10s %-10s %-10s\n"), "code", "degree", "name", "gender", "birth");

            for (Employee x : employeesList) {
                x.display();
            }
        }
        if (choice.equals("dac")) {
            System.out.printf(("%-10s %-20s %-10s %-10s %-10s %-10s\n"), "code", "Customer type", "name", "gender", "birth");
            for (Customer x : customersList) {
                x.display();
            }

        }
    }
    
    public void statistics(){
        System.out.println("===================Customer statistics=============");
        int newNum=0;
        int memberNum=0;
        int vipNum=0;
        for (Customer x : customersList) {
            if(x.getcType().equalsIgnoreCase("new"))
                newNum++;
            else if(x.getcType().equalsIgnoreCase("member"))
                memberNum++;
            else
                vipNum++;
        }
        System.out.println("Number of new: "+newNum);
        System.out.println("Number of member: "+memberNum);
        System.out.println("Number of vip: "+vipNum);
    }
    
    public void exit(){
        String select="";
        System.out.println("Do you want to exit the program (y/n)?");
        do{
            select = validation.getNonBlankStr("Select: ", "not empty");
            if(select.equalsIgnoreCase("Y"))
                System.exit(0);
            if(select.equalsIgnoreCase("N"))
                break;
        }while(true);
        return;
    }
}
