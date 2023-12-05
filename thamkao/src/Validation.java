
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Validation {
    public boolean checkSquareNumber(int n){
        if(Math.sqrt(n)*Math.sqrt(n)==n){
            return true;
        }
        return false;
    }
    
    public void getNumber(String inputString){
        HashMap<String,ArrayList<Integer>> hashNumber = new HashMap();
        String number = getNumberCharacter(inputString);
        String[] listNumber = number.split(",");
        int lenNumber = listNumber.length;
        ArrayList<Integer> liPerfectSquare = new ArrayList<>();
        ArrayList<Integer> liOdd = new ArrayList<>();
        ArrayList<Integer> liEven = new ArrayList<>();
        ArrayList<Integer> liAll = new ArrayList<>();
        
        for(int i = 0; i<lenNumber; i++){
            int numberCheck = Integer.parseInt(listNumber[i]);
            if(numberCheck % 2 == 1){
                liOdd.add(numberCheck);
            }
            if(numberCheck % 2 == 0){
                liEven.add(numberCheck);
            }
            if(checkSquareNumber(numberCheck)){
                liPerfectSquare.add(numberCheck);
            }
            liAll.add(numberCheck);
            hashNumber.put("Perfect Square number", liPerfectSquare);
            hashNumber.put("Odd number", liOdd);
            hashNumber.put("Even number", liEven);
            hashNumber.put("All number", liAll);
            
            for(Map.Entry m : hashNumber.entrySet()){
                System.out.println(m.getKey()+"  "+m.getValue());
            }
        }
        
    }
    
     public void getCharacter(String inputString){
         HashMap<String,String> hashString = new HashMap<>();
         hashString.put("Uppercase", getUpperCharacter(inputString));
         hashString.put("Lowercase", getLowerCharacter(inputString));
         hashString.put("Special", getSpecialCharacter(inputString));
         hashString.put("All character", getAllCharacter(inputString));
        }
     
     public String getAllCharacter(String inputString){
         String allCharacter = inputString.replaceAll("[0-9]", "");
         return allCharacter;
     }
     
     public String getUpperCharacter(String inputString){
         String uppercase = inputString.replaceAll("\\W|[0-9]|[a-z]", "");
         return uppercase;
     }
     
     public String getLowerCharacter(String inputString){
         String uppercase = inputString.replaceAll("\\W|[0-9]|[A-Z]", "");
         return uppercase;
     }
     
     public String getSpecialCharacter(String inString){
         String special = inString.replaceAll("\\w", "");
         return special;
     }
     
     public String getNumberCharacter(String inputString){
         String number = inputString.replaceAll("\\D+", ",");
         return number;
     }
}
