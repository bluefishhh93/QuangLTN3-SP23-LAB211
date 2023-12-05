
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public static final Scanner sc = new Scanner(System.in);

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public Country() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    public void display() {
        String areaFormat = ((this.getTotalArea() % 1.0f) == 0) 
        ? "%-16.1f"   //If area is integer then display 1 zero after radix point
        : "%-16.16s"; //Otherwise display fraction
        System.out.printf("%-16.16s%-16.16s\n" 
                + areaFormat, this.getCountryCode(), 
                this.getCountryName(), 
                this.getTotalArea());
    }
}
