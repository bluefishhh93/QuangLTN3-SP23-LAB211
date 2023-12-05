/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author xuant
 */
public class FruitShop {
    private ArrayList<Fruit> fruitList = new ArrayList<>();
//    private ArrayList<Orders> orderList = new ArrayList<>();
    private Hashtable<String, ArrayList<Orders>> customers = new Hashtable<>();
    Scanner sc = new Scanner(System.in);

    public FruitShop() {
        fruitList.add(new Fruit(1,"Coconut", 2, 100, "Vietnam"));
        fruitList.add(new Fruit(2,"Orange", 3, 100, "US"));
        fruitList.add(new Fruit(3,"Apple", 4, 100, "Thailand"));
        fruitList.add(new Fruit(4,"Grape", 6, 100, "Vietnam"));
    }
    
    public void createProduct(){
    int fruitId;
    String fruitName;
    double price;
    int quantity;
    String origin;
    do{
        String select;
       fruitId = Validation.getInteger("Fruit ID(input an integer!): ", "Invalid ID");
       int pos = findID(fruitId);
       if(pos>=0){
           System.out.println("This id already existed!");
           return;
       }
       fruitName = Validation.getString("Fruit name: ","Invalid fruit name!");
       price = Validation.getADouble("Price:", "Invalid price!");
       quantity = Validation.getInteger("Quantity: ", "Invalid quantity");
       origin = Validation.getString("origin: ", "Invalid origin");
       if(!checkDuplicated(fruitName, origin)){
       fruitList.add(new Fruit(fruitId, fruitName, price, quantity, origin));
       }else
            System.out.println("This fruit already exist!");
       select = Validation.getSelection("Do you want to countinue (Y/N)", "Please enter Y or N");
       if(select.equalsIgnoreCase("N"))
           return;
    }while(true);
    }
    
    public void shopping() {
        String product;
        int quantityOrders;
        double priceOrders;
        double amount;
        double total=0;
        String customerName;
        ArrayList<Orders> ordersList = new ArrayList<>();
        if (fruitList.isEmpty()) {
            System.out.println("Nothing to buy!");
            return;
        }
        while (true) {
            displayFruit();
            int choice;
            choice = Validation.getFruitItem(fruitList.size());
            System.out.println("You selected: " + fruitList.get(choice - 1).getFruitName());
            int quantity = Validation.getInteger("Please input quantity:", "please in put integer!");

            product = fruitList.get(choice - 1).getFruitName();
            quantityOrders = quantity;
            priceOrders = fruitList.get(choice - 1).getPrice();
            amount = quantityOrders * priceOrders;
            ordersList.add(new Orders(product, quantityOrders, priceOrders, amount));
            total+=amount;
            String select = Validation.getSelection("Do you want to order now (Y/N)?", "Please enter Y or N");
            if (select.equalsIgnoreCase("Y")) {
                System.out.printf("|%-15s|%-15s|%-10s|%10s\n","Product","Quantity","Price","Amount");
                for(int i = 0; i < ordersList.size();i++){
                    System.out.printf("|%-15s|%-15s|%-10s|%10s\n",ordersList.get(i).getProduct()
                                                                 ,ordersList.get(i).getQuantityOrders()
                                                                 ,ordersList.get(i).getPriceOrders()
                                                                 ,ordersList.get(i).getAmount());                  
                }
                System.out.println("Total: "+total);
                customerName = Validation.getString("Input your name: ", "Name can not empty!");
                customers.put(customerName, ordersList);
                return;
            }
        }

        
    }
    public void viewOrders(){
        if(customers.isEmpty()){
            System.out.println("There are no customer yet!");
            return;
        }
        //double total=0;
        Set<String> nameSet = customers.keySet();

        for (String x : nameSet) {
            double total=0;
            ArrayList<Orders> list = new ArrayList<>();
            list=customers.get(x);
            System.out.println("Customer: "+x);
            System.out.printf("|%-15s|%-15s|%-10s|%10s\n","Product","Quantity","Price","Amount");
            for (Orders y : list) {
                total += y.getAmount();
                y.printOrders();
            }
            
            System.out.println("Total:"+total+"$");
            
        }
    }
    
    public int findID(int id){
        if(fruitList.isEmpty())
            return -1;
        for(int i =0; i < fruitList.size();i++){
            if(fruitList.get(i).getFruitId()==id)
                return i;
        }
        return -1;
    }    
    
    public boolean checkDuplicated(String fruitName,String origin){
        for (Fruit x : fruitList) {
            if(x.getFruitName().equalsIgnoreCase(fruitName)&&x.getOrigin().equalsIgnoreCase(origin))
                return true;
        }
        return false;
    }
    
    public void displayFruit(){
        if(fruitList.isEmpty()){
            System.out.println("There are no fruit in shop yet!");
            return;
        }
        System.out.println("List of Fruit:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for(int i=0;i<fruitList.size();i++){
            System.out.printf("%8d %15s %18s %13s\n",(i+1),fruitList.get(i).getFruitName(),fruitList.get(i).getOrigin(),fruitList.get(i).getPrice());
        }
    }
}
