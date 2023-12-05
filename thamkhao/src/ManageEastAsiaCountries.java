/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class ManageEastAsiaCountries {

    public ManageEastAsiaCountries() {
    }

    /**
     * Ask user to enter information of country. A new country variable will be
     * created to hold the input values. Then it will become the parameter for
     * the addCountryInformation function.
     *
     * @param countryList list of countries
     * @return addCountryInformation(newCountry, countryList)
     * @throws java.lang.Exception
     */
    public EastAsiaCountries addCountryInformation(ArrayList<EastAsiaCountries> countryList) throws Exception {
        EastAsiaCountries newCountry = new EastAsiaCountries();
        //Only accept user to input 11 countries
        if (countryList.size() == 11) {
            throw new Exception("There are already 11 countries in the list. "
                    + "Cannot input new country");
        }
        //Ask user again if the input is not valid
        while (true) {
            try {
                newCountry.setCountryCode(Utility.findExistedCode(
                        countryList, Utility.inputCode("Enter code of country: ")));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //ask user again if the input is not valid
        while (true) {
            try {
                newCountry.setCountryName(Utility.findExistedName(countryList, Utility.inputName("Enter name of country: ")));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //Keep asking for area if the program catches an exception
        while (true) {
            try {
                newCountry.setTotalArea(Utility.inputTotalArea(
                        "Enter total Area: "));
                break;
            } catch (Exception e) {
                //Tell user to enter an float if the input is not a number
                if (e instanceof NumberFormatException) {
                    System.out.println("Invalid input. Area must be "
                            + "a positive float or integer!");
                } else {
                    System.out.println(e.getMessage());
                }
            }
        }
        //Keep asking for terrain if program catches an exception
        while (true) {
            try {
                newCountry.setCountryTerrain(Utility.inputTerrain(
                        "Enter terrain of country: "));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return addCountryInformation(newCountry, countryList);
    }

    /**
     * add country to the list
     *
     * @param newCountry
     * @param countryList
     * @return
     */
    public EastAsiaCountries addCountryInformation(EastAsiaCountries newCountry,
            ArrayList<EastAsiaCountries> countryList) {
        try {
            countryList.add(newCountry);
        } catch (Exception e) {
            //Change the message of the exception
            if (e instanceof IndexOutOfBoundsException) {
                System.out.println("Index out of range");   
            } else {
                System.out.println(e.getMessage());
            }
        }
        return newCountry;
    }

    /**
     * Display information of countries you have just inputted.
     *
     * @param lastInputCountry
     * @return the country that you've recently inputted
     * @throws Exception if you haven't entered anything
     */
    public EastAsiaCountries getRecentlyEnteredInformation(
            EastAsiaCountries lastInputCountry) throws Exception {
        //Check if user has entered input at least 1 time or not
        if (lastInputCountry == null) {
            throw new Exception("You haven't entered anything");
        }
        System.out.printf("%-16s%-16s%-16s%-16s\n",
                "ID", "Name", "Total Area", "Terrain");
        return lastInputCountry;
    }

    /**
     * Search information of countries by user-entered name. Input will be
     * automatically converted to lowercase
     *
     * @param countryList
     * @return array of countries that matches a part of the name
     * @throws Exception if the list is empty or not found any country or the
     * input name is invalid
     */
    public EastAsiaCountries[] searchInformationByName(
            ArrayList<EastAsiaCountries> countryList)
            throws Exception {
        Pattern COUNTRY_NAME = Pattern.compile(
            "^" //Start of line
            + "\\s*" //0 or many space
            + "([A-Za-z]+\\s?)*" //0 or many word that separate by 0 or 1 space
            + "\\s*" //0 or many space
            + "$");              //end of line
        ArrayList<EastAsiaCountries> result = new ArrayList<>();
        //If the data is empty throw new exception
        if (countryList.isEmpty()) {
            throw new Exception("List of countries is empty!");
        }
        String input = Utility
                .getNonBlankStr("Enter the name you want to search for: ")
                .toLowerCase();
        //If the input is not valid then throw new exception
        if (!Utility.isValid(input, COUNTRY_NAME)) {
            throw new Exception("Not a valid name!");
        }
        //Searching for name in data that matches the input ignoring case
        for (EastAsiaCountries c : countryList) {
            //add the country in data that matches the input to the result list
            if (c.getCountryName().toLowerCase().contains(input)) {
                result.add(c);
            }
        }
        //If it doesn't found any country then throw new exception
        if (result.isEmpty()) {
            throw new Exception("Not found");
        }
        int count = result.size();
        //Display the total number of countries that the search found
        if (count == 1) {
            System.out.println("Found 1 country");
        } 
        //If more than 1 search was found then we will tell user the total count
        else {
            System.out.println("Found " + count + " countries");
        }
        Utility.displayTableOfCountries(result.toArray(new EastAsiaCountries[result.size()]));
        return result.toArray(new EastAsiaCountries[result.size()]);
    }

    /**
     * Sort information of countries by ascending order of names
     *
     * @param countryList
     * @return the sorted array of countries
     * @throws Exception if the array is empty
     */
    public EastAsiaCountries[] sortInformationByAscendingOrder(
            ArrayList<EastAsiaCountries> countryList)
            throws Exception {
        //throw exception if the list is empty
        if (countryList.isEmpty()) {
            throw new Exception("List of countries is empty!");
        }
        Collections.sort(countryList);
        Utility.displayTableOfCountries(countryList.toArray(new EastAsiaCountries[countryList.size()]));
        return countryList.toArray(new EastAsiaCountries[countryList.size()]);
    }

    /**
     * Display the menu to the screen
     * @param listOptions list of option to display
     */
    public void displayMenu(ArrayList<String> listOptions) {
        
        System.out.println("");
        System.out.println("                               Menu");
        System.out.println("==================================================="
                + "=======================");
        int totalOption = listOptions.size();
        //print all options start with index from 1 to the end
        for (int i = 0; i < totalOption; i++) {
            System.out.println((i + 1) + ". " + listOptions.get(i));
        }
        System.out.println("==================================================="
                + "========================");
    }

    /**
     * Ask user to select an option from min to max.
     *
     * @param message message to user
     * @param min minimum value
     * @param max maximum value
     * @return the input value
     */
    public int selectOption(String message, int min, int max) {
        String input;
        input = Utility.getNonBlankStr(message);
        try {
            //throw exception if input is empty
            if (input.isEmpty()) {
                throw new Exception("Empty input");
            }
            int num;
            try {
                num = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Not a valid number");
            }
            //Throw exception if the input is out of range
            if (num < min || num > max) {
                throw new Exception("Input out of range [1-5]");
            }
            return num;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return selectOption(message, min, max);
        }
    }
}
