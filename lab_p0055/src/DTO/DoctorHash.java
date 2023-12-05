/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuant
 */
public class DoctorHash {
    private HashMap<String, Doctor> doctorMap;

    public DoctorHash() {
        doctorMap = new HashMap();
        doctorMap.put("DOC 1", new Doctor("DOC 1", "Nghia", "orthodontic", 3));
        doctorMap.put("DOC 2", new Doctor("DOC 2", "Phuong", "Obstetrics", 2));
        doctorMap.put("DOC 3", new Doctor("DOC 3", "Lien", "Obstetrics", 1));
    }
    
    public void addDoctor(){ 
    System.out.println("--------------------------------ADD DOCTOR---------------------------");
    String code;
    String name;
    String specialization;
    int availability=0;
     while(true){
            try {
                code = Validation.findExistedCode(doctorMap, Validation.getCode());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    while(true){
            try {
                name = (Validation.getStr("Enter name: "));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        while(true){
            try {
                specialization = (Validation.getStr("Enter specialization: "));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        while(true){
            try {
                availability = (Validation.checkAvailability());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
        try {
            addDoctor(new Doctor(code, name, specialization, availability));
            System.out.println("Doctor added successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean addDoctor (Doctor doctor) throws Exception{
        
        if (doctorMap == null) {
            throw new Exception("Database does not exit!");
        }      
        if(doctorMap == null)
            throw new Exception("Database does not exit!");
         if (doctor == null) {
            throw new Exception("Data does not exist");
        }       
         
        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }
    
    
    public boolean updateDoctor(Doctor doctor) throws Exception {
        System.out.println("----------------------------UPDATE DOCTOR---------------------------");
        String name;
        String specialization;
        int availability = 0;
        if (doctorMap == null) {
            throw new Exception("Database does not exit!");
        }
        
        if(doctorMap.isEmpty()){
            throw new Exception("There is no doctor to update");
        }
        String code = Validation.getCode();
        if (!doctorMap.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist");
        }
        doctor = doctorMap.get(code);
        
         
        if (doctor == null) {
            throw new Exception("Data does not exist");
        }
        while (true) {
            try {
                name = (Validation.getStrCanEmpty("Enter name: "));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                specialization = (Validation.getStrCanEmpty("Enter specialization: "));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                availability = (Validation.checkAvailability());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        String newName = (name == null || name.isEmpty()) ? doctor.getName():name;
        String newSpecialization = (specialization == null || specialization.isEmpty())? doctor.getSpecialization():specialization;
        int newAvailability = (availability == 0) ? doctor.getAvailability() : availability;
        
        doctorMap.put(code, new Doctor(code,newName, newSpecialization, newAvailability));
        System.out.println("Update successful!");
        return true;
    }
    
    public boolean deleteDoctor (Doctor doctor) throws Exception{
        System.out.println("---------------------------------DELETE DOCTOR-------------------------");
        if (doctorMap == null) {
            throw new Exception("Database does not exit!");
        }
        
        if(doctorMap.isEmpty()){
            throw new Exception("There is no doctor to delete");
        }
        String code = Validation.getCode();
        if (!doctorMap.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist");
        }
        doctor = doctorMap.get(code);
        doctorMap.remove(code);
        System.out.println("Deleted successful!");
        return true;
    }
    
    public void searchDoctor(){
        System.out.println("-------------------------SEARCH DOCTOR--------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine().trim();
        try {
            searchDoctor(input);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        HashMap<String, Doctor> doctorFounded = new HashMap<String, Doctor>();
        if (doctorMap.isEmpty()) {
            throw new Exception("There are no doctor to search");
        }
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (input == null || input.isEmpty()) {
            doctorFounded = doctorMap;
            display(doctorFounded);
            return doctorFounded;
        }

        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getCode().contains(input) || doctor.getName().contains(input) || doctor.getSpecialization().contains(input)) {
                doctorFounded.put(doctor.getCode(), doctor);
            }
        }
        display(doctorFounded);
        return doctorFounded;
    }

    public void display(HashMap<String,Doctor> searchFounded){
        System.out.println("---------------------------RESULT--------------------------------------");
        System.out.printf("%-7s %-20s %-20s %-13s\n","Code","Name","Specialization","Availability");
         for (HashMap.Entry<String, Doctor> item : searchFounded.entrySet()) {
            item.getValue().Display();
        }
         
    }
}
