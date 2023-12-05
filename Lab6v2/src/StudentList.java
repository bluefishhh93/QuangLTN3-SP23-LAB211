
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class StudentList {

    ArrayList<Student> arr = new ArrayList<>();

    public StudentList() {
        
    }

    public Student search(String code) {
        code = code.toUpperCase().trim();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCode().equals(code)) {
                return arr.get(i);
            }
        }
        return null;

    }

    private boolean isDuplicated(String code) {
        code.toUpperCase().trim();
        return search(code) != null;
    }

    public void addStudent() {
        String newCode, newName;
        int newMark;
        boolean codeDuplicated = false;
        do {
            newCode = Inputter.inputPattern("St. code s000: ", "[sS][\\d]{3}");
            newCode = newCode.toUpperCase().trim();
            codeDuplicated = isDuplicated(newCode);
            if (codeDuplicated) {
                System.out.println("Code is duplicated!");
            }
        } while (codeDuplicated == true);
        newName = Inputter.inputNonBlank("input name: ");
        newMark = Inputter.inputInt("Input mark: ", 0, 10);
        Student st = new Student(newCode, newName, newMark);
        arr.add(st);
        System.out.println("Student" + newCode + "has been added");
    }

    public void searchStudent() {
        String sCode;
        if (arr.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            sCode = Inputter.inputStr("Input student code to search:");
            Student st = search(sCode);
            if (st == null) {
                System.out.println("Student" + sCode + "Does not existed.");
            } else {
                System.out.println("Found: " + st);
            }
        }
    }

    public void updateStudent() {
        if (arr.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            String uCode = Inputter.inputStr("Input student code to update:");
            Student st = search(uCode);
            if (st == null) {
                System.out.println("Student" + uCode + "does not exit");
            } else {
                String newName, msg;
                int newMark;
                newMark = st.getMark();
                msg = "Old mark: " + newMark + ", new Mark :";
                newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                newName = st.getName();
                msg = "Old name: " + newName + ", new name: ";
                newName = Inputter.inputNonBlank(msg);
                st.setName(newName);
                System.out.println("Student" + uCode + "has been updated");

            }
        }
    }

    public void removeStudent(){
        if(arr.isEmpty()){
            System.out.println("Empty list!");
        }
        else{
            String rCode = Inputter.inputStr("Input student code to remove:");
            Student st = search(rCode);
            if(st==null)
                System.out.println("Sudent"+rCode+"does not exit");
            else{
                arr.remove(st);
                System.out.println("Student"+rCode+"has been removed");
            }
        }
    }
    
    public void printAll(){
        if(arr.isEmpty())
            System.out.println("Empty list!");
        else{
            for(Student x : arr)
                System.out.println(x);
        }
        System.out.println("Total "+arr.size()+" Student");
    }
}
