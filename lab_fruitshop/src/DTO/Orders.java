/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author xuant
 */
public class Orders {
    private String product;
    private int quantityOrders;
    private double priceOrders;
    private double amount;

    public Orders(String product, int quantityOrders, double priceOrders, double amount) {
        this.product = product;
        this.quantityOrders = quantityOrders;
        this.priceOrders = priceOrders;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantityOrders() {
        return quantityOrders;
    }

    public void setQuantityOrders(int quantityOrders) {
        this.quantityOrders = quantityOrders;
    }

    public double getPriceOrders() {
        return priceOrders;
    }

    public void setPriceOrders(double priceOrders) {
        this.priceOrders = priceOrders;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void printOrders(){
        System.out.printf("|%-15s|%-15s|%-10s|%10s\n",product,quantityOrders,priceOrders,amount);
    }
}
