
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class studentManager {
    public static void main(String[] args) {
//      String[] options= {"Add new student","Search a student",
//        "Update name and mark","Remove a student","List all","Quit"};
        ArrayList option = new ArrayList();
        option.add("Add new stutdent");
        option.add("Search a student");
        option.add("Update name and mark");
        option.add("Remove a student");
        option.add("List all");
        option.add("Quit");
        
        int choice =0;
        StudentList list = new StudentList();
        do{
            System.out.println("\nStudent managing Program");
            choice=Menu.getChoice(option);
            switch(choice){
                case 1: list.addStudent(); break;
                case 2: list.searchStudent(); break;
                case 3: list.updateStudent(); break;
                case 4: list.removeStudent(); break;
                case 5: list.printAll(); break;
                default: System.out.println("Bye!");
            }
        }while(choice>0&&choice<6);
    }
}
