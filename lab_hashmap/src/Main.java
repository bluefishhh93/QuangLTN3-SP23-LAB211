
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Student s1 = new Student(1, "An");
        FuMemoryCached.putObject("a", s1, 5000); //time to live 5s
        Student s2 = new Student(2, "Binh"); 
        FuMemoryCached.putObject("b", s2, 10000); //time to live 10s
        System.out.println(FuMemoryCached.getObject("a"));
        System.out.println(FuMemoryCached.getObject("b"));
        Thread.sleep(6000); //program sleep 6s
        System.out.println("After 6 seconds");
        System.out.println(FuMemoryCached.getObject("a")); 
        System.out.println(FuMemoryCached.getObject("b"));
        

    }
  
    
}
