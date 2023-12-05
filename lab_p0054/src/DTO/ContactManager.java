/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xuant
 */
public class ContactManager {
     int id = 1;
    public boolean addContact(ArrayList<Contact> list, Contact contact) {
        System.out.println("-------- Add a Contact --------");
        contact = new Contact();
        String fullName;
        String group;
        String address;
        String phone;
        String lastName;
        String firstName;
        int ID = id;
        fullName = Validation.getStr("Enter Name: ");
        StringTokenizer st = new StringTokenizer(fullName, " ");
        lastName = "";
        firstName = st.nextToken();
        while (st.hasMoreElements()) {
            lastName += st.nextToken() + " ";
        }
        group = Validation.getStr("Enter group: ");
        address = Validation.getNonBlankStr("Enter address: ");
        phone = Validation.getPhone();
        
        contact.setID(ID);
        contact.setFullName(fullName);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setGroup(group);
        contact.setPhone(phone);
        contact.setAddress(address);
        
        id++;
        return list.add(contact);
    }
    
    public void disPlayAll(ArrayList<Contact> list){
        if(list.isEmpty())
        {
            System.out.println("There are no contact to display");
            return;
        }
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.printf("%-15s %-15s %-15s %-20s %-8s %-15s %-10s\n","ID","Name","First Name","Last Name","Group","Address","Phone");
        for (Contact x : list) {
            x.display();
        }
    }
    
    public boolean deleteContact(ArrayList<Contact> list, Contact contact){
        Scanner sc = new Scanner(System.in);
        System.out.println("-------- Delete a Contact --------");
        
        int ID;
         do{
              try {
                  System.out.print("Enter ID Contact to delete");
                  ID = Integer.parseInt(sc.nextLine());
                  break;
              } catch (Exception e) {
                  System.out.println("ID must be a number");
              }
          }while(true);
         contact = Validation.checkExistContact(list, ID);
        return list.remove(contact);
    }
}
