/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author xuant
 */
public class DictionnaryManager {
    Validation validation = new Validation();
    public HashMap<String, String> dictionary;
    IoFile io = new IoFile();

    public DictionnaryManager() {
        dictionary = new HashMap();
        loadDictionaryFromFile();
    }

    public void loadData() {
        io.loadDictionaryFromFile(dictionary);
    }

    public void addWord() {
        System.out.println("------------- Add -------------");
        String eng, vi;
        //enter english
        eng = validation.inputStr("Enter english: ", "Invalid input");
        //checking is this english existed in dictionary
        if(dictionary.containsKey(eng)){
            //select to update or cancel
            String choice = validation.getChoice();
            if(choice.equalsIgnoreCase("N")){
                System.out.println("Failed");
                return;
            }else{
                //update new vietnamese mean
                vi = validation.inputStr("Enter new vietnamese mean: ", "Invalid input");
                addWord(eng, vi);
                System.out.println("Update successful!");
                return;
            }
        }
        vi = validation.inputStr("Enter vietnames", "Invalid input");
        //add new word
        addWord(eng, vi);
        System.out.println("Successful!");
    }

    public boolean addWord(String eng, String vi) {
        dictionary.put(eng, vi);
        return true;
    }
    
    public void removeWord(){
        System.out.println("------------ Delete ----------------");
        String eng = validation.inputStr("Enter englist: ", "Invalid input!");
        if(!dictionary.containsKey(eng)){
            System.out.println("Not found "+eng+" in database!");
            return;
        }else{
            removeWord(eng);
        }
    }
    public boolean removeWord(String eng) {
        dictionary.remove(eng);
        System.out.println("Removed successful!");
        return true;
    }
    
    public void translate(){
        System.out.println("------------- Translate ------------");
        if(dictionary.isEmpty())
        {
            System.out.println("No dictionary in database!");
            return;
        }
        String eng = validation.inputStr("Enter english", "Invalid input");
        if(!dictionary.containsKey(eng)){
            System.out.println("Not found this word in databse!");
            return;
        }else{
            System.out.println(translate(eng));
        }
    }
    public String translate(String eng) {
        return dictionary.get(eng);

    }

    public void loadDictionaryFromFile() {
        try {
            File file = new File("src\\dictionary.dat");
            //check the file is existed or empty
            if (!file.exists()||file.length()==0) {
                return;
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.dictionary = (HashMap<String,String>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   public void saveDictionaryToFile() {
    try {
        File file = new File("src\\dictionary.dat");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.dictionary);
        oos.close();
        fos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
