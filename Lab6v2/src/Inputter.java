
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    public static int inputInt(String msg, int min, int max){
        if(min>max){
            int tmp = max;
            max = min;
            min = tmp;
        }
        int data;
        do{
            System.out.print(msg);
            data = Integer.parseInt(sc.nextLine());
        }while(max < data || data < min);
        return data;
 }
    public static String inputNonBlank(String msg){
        String data;
        do{
        System.out.println(msg);
        data=sc.nextLine().trim();
        }while(data.length()==0);
        return data;
    }
    public static String inputPattern(String msg, String pattern){
        String data;
        do{
            System.out.print(msg);
            data=sc.nextLine().trim();
        }while(!data.matches(pattern));
        return data;
    }
    
    public static String inputStr(String msg){
    System.out.print(msg);
        String data= sc.nextLine().trim();
        return data;
}
}
