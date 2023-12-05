/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author xuant
 */
public class Employee extends Person{
   private String eCode;
   private String degree;

    public Employee(String eCode, String degree, String name, String gender, String birth) {
        super(name, gender, birth);
        this.eCode = eCode;
        this.degree = degree;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
   
    public void display(){
        System.out.printf(("%-10s %-20s %-10s %-10s %-10s %-10s\n"),eCode,degree,name,gender,birth);
    }
}
