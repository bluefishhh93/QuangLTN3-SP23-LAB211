/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Main {
    public static void main(String[] args) {
        String str = "4Nam@9!Bay8K#Tam";
        System.out.println("Input string: "+str);
        Validation v1 = new Validation();
        v1.getCharacter(str);
        v1.getNumber(str);
    }
}
