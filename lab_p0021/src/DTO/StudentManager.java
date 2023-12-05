/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author xuant
 */
public class StudentManager {

    private ArrayList<Student> stList = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    private int count = 0;

    public void create() {
        String select = "";
        int id;
        int pos;
        String name, semester, courseName;
        if (count > 10) {
            select = Validation.continueCreate();
            if (select.equalsIgnoreCase("N")) {
                return;
            }
        }
               
        id = Validation.getId();
        pos = findStudent(id);
        if(pos>=0){
            System.out.println("This id existed!");
            System.out.println("Do you want to add more course for this student!(Y/N)");
            String add = Validation.continueCreate();
            if(add.equalsIgnoreCase("Y")){
                addCourse(pos);
                count++;
            }
            return;
        }
       
        System.out.print("Input name: ");
        name = Validation.InputString();
        System.out.print("Input Semester: ");
        semester = Validation.InputString();
        System.out.print("Input course name: ");
        courseName = Validation.getCourseName();
        stList.add(new Student(id, name, semester, courseName));
        System.out.println("A student was created!");
        count++;
    }
    
    public void findAndSort(){
        Collections.sort(stList);
        System.out.print("Input student name or a part of student name: ");
        String name = Validation.InputString();
        for (Student x : stList) {
            if(x.getName().indexOf(name, 0)!=-1){
                System.out.println(x);
            }
        }
    }
    
    public void updateOrDelete(){
        String courseName,semester;
        ArrayList<Student> updateList = new ArrayList<>();
        int index =1;
        int select;
        if(stList.isEmpty()){
            System.out.println("There are no student!");
            return;
        }
        int id = Validation.getId();
        int pos = findStudent(id);
        if(pos ==-1){
            System.out.println("Not found!");
            return;
        }
            
        for (Student x : stList) {
            if(x.getId()==id){
                updateList.add(x);
                System.out.println(index+":"+x);
                index++;
            }
        }
        String choice = Validation.updateOrDelete();
        if(choice.equalsIgnoreCase("U")){
        System.out.println("Select number to update!");
        select= Validation.getInteger(updateList.size(),"Update");
        System.out.print("Input new Semester: ");
        semester = Validation.InputString();
        System.out.print("Input new course name: ");
        courseName = Validation.getCourseName();
        for(int i =0; i < stList.size();i++){
            if(stList.get(i).getCourseName().equalsIgnoreCase(courseName)&&stList.get(i).getSemester().equalsIgnoreCase(semester)&&stList.get(i).getId()==id){
                System.out.println("This semester already had this course!");
                return; 
            }    
        }
        updateList.get(select-1).setCourseName(courseName);
        updateList.get(select-1).setSemester(semester);
        System.out.println("Updated!");
        }
        else{
        System.out.println("Select number to Delete!");
        select = Validation.getInteger(updateList.size(),"Delete");
            for(int i=0; i<stList.size();i++){
                if(stList.get(i)==updateList.get(select-1))
                    stList.remove(i);
            }
            System.out.println("Deleted");
        }
        
        
    }
    
    public void report(){
//         for(Student x : stList){
//             System.out.printf("|%-15s|%-15s|%-10s\n",x.getName(),x.getCourseName(),x.getSemester());
//         }
//        Map< String, Integer> courseCount = new HashMap< String, Integer>();
//        for (Student student : stList) {
//            if(courseCount.containsKey(student.getName())&&student.getCourseName().equalsIgnoreCase("Java"))
//                courseCount.put(student.getName(), courseCount.get(student.getName())+1);
//            else
//                courseCount.put(student.getName(), 1);
//        }
//        Set<String> name = courseCount.keySet();
//        for (String x : name) {
//            System.out.printf("|%-15s|%-15s|%-10s\\n",x,"java",courseCount.get(x));
//        }
//        courseCount.clear();
          prinReport("Java");
          prinReport(".Net");
          prinReport("C/C++");
        
        
    }
    
    public int findStudent(int id){
        if(stList.isEmpty())
            return -1;
        for(int i =0; i < stList.size();i++){
            if(stList.get(i).getId()==id)
                return i;
        }
        return -1;
    }    
    public void addCourse(int pos){
        String name,courseName,semester;
        int id;
        id = stList.get(pos).getId();
        name = stList.get(pos).getName();
        System.out.print("Input Semester: ");
        semester = Validation.InputString();
        System.out.print("Input course name: ");
        courseName = Validation.getCourseName();
        for(int i =0; i < stList.size();i++){
            if(stList.get(i).getCourseName().equalsIgnoreCase(courseName)&&stList.get(i).getSemester().equalsIgnoreCase(semester)){
                System.out.println("This semester already had this course!");
                return; 
            }    
        }
         stList.add(new Student(id, name, semester, courseName));
       
    }
    public void prinReport(String courseName){
        Map< String, Integer> courseCount = new HashMap< String, Integer>();
        for (Student student : stList) {
            if(courseCount.containsKey(student.getName())&&student.getCourseName().equalsIgnoreCase(courseName))
                courseCount.put(student.getName(), courseCount.get(student.getName())+1);
            else if(student.getCourseName().equalsIgnoreCase(courseName))
                courseCount.put(student.getName(), 1);
        }
        Set<String> name = courseCount.keySet();
        for (String x : name) {
            System.out.printf("|%-15s|%-15s|%-10s|\n",x,courseName,courseCount.get(x));
        }
    }
    public void displayStudentByID(int id){
        
    }
    
}
