/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.FruitShop;

/**
 *
 * @author xuant
 */
public class Test {
    public static void main(String[] args) {
        String[] options = {"Create Fruit","View orders","Shopping","Exit"};
        FruitShop fs = new FruitShop();
        int choice;

        do{
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                   fs.createProduct();
                    break;
                case 2:
                    fs.viewOrders();
                    
                    break;
                case 3:
                    fs.shopping();
                    break;
                case 4:
                    System.exit(0);                 
            }
        }while(true);
    }
    }

