
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Normalizing {
    //remove space in front and back, only one space between two words
    public static String oneSpaceNormal(String text){
        text=text.trim().replaceAll(" +", " ");
        return text;
    }
    
    //Only one space after comma (,), dot (.) and colon (:)
    public static String signNormal(String text) {
        char ch[] = {',', '.', ':'};
        for (char c : ch) {
            text = text.replace(" " + c, c + "");
            text = text.replace(c+" ", c+"");
            text = text.replace(c+"", c+" ");
        }
//        for (int i = 0; i < text.length() - 1; i++) {
//            if ((text.charAt(i) == ',' || text.charAt(i) == '.' || text.charAt(i) == ':') && text.charAt(i + 1) != ' ') {
//                text = text.replace(text.charAt(i) + "", text.charAt(i) + " ");
//            }
//        }

        return text;
    }
//Capitalizing at the first letter and after dot
    public static String CapitalNormal(String text){
         text = text.toLowerCase();
         String firstLetter = text.substring(0, 1);
    String remainingLetters = text.substring(1, text.length());
    // change the first letter to uppercase
    firstLetter = firstLetter.toUpperCase();
    // join the two substrings
    text = firstLetter + remainingLetters;
    
    StringBuffer sb = new StringBuffer(text);
    for(int i=0; i < sb.length();i++){
        if(sb.charAt(i)=='.'){
            char pos =  sb.charAt(i+2);
            sb.setCharAt(i+2, Character.toUpperCase(pos));
        }
    }
    
        return sb.toString();
    }
//    public static String quotesNormal(String text){
//        
//        return text;
//    }
//Inserting the dot at the end if the text do not have
    public static String endDotNormal(String text){
        if (text.endsWith(".")) {
            return text;
        } else {
            return text + ".";
        }
       
    }
    
//no space in quotes    
   public static String quotesNormal(String text) {
        String regex = "([“])([\\S ]*)([”])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "$1" + matcher.group(2).trim() + "$3");
        }
        matcher.appendTail(stringBuffer);
        return text = stringBuffer.toString();
    }
    
}
