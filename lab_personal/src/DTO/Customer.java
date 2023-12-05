/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author xuant
 */
public class Customer extends Person{
    private String cCode;
    private String cType;

 
    public Customer(String cCode, String cType, String name, String gender, String birth) {
        super(name, gender, birth);
        this.cCode = cCode;
        this.cType = cType;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }
    
    public void display(){
        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s\n",cCode,cType,name,gender,birth);
    }
    
    
}
