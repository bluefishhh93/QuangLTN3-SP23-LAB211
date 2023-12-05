/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1bt1;

/**
 *
 * @author HP
 */
import java.util.Scanner;
public class Lab1bt1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        String ten;
        double diem;
        System.out.print("Nhap ten: ");
        ten=input.nextLine();
        System.out.print("Nhap diem: ");
        diem=input.nextDouble();
        System.out.print("<<"+ten+">>"+"<<"+diem+">>");
    }
    
}
