
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class test {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        File f = new File("src\\input.txt");
        inputFile(f);
        
    }
    public static void inputFile(File f){
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            
            while(true){
                String line = br.readLine();
                if(line == null){
                    break;
                }else{     
                    sb.append(line+" ");
                }
            }
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        String text = sb.toString();
       text = Normalizing.oneSpaceNormal(text);
       text = Normalizing.signNormal(text);
       text = Normalizing.CapitalNormal(text);
       text = Normalizing.endDotNormal(text);
       text = Normalizing.quotesNormal(text);
        outputFile(new StringBuffer(text));
    }
    
    
    public static void outputFile(StringBuffer sb){
         try {
            // TODO code application logic here
            PrintWriter pw = new PrintWriter("src\\output.txt","UTF-8");
            pw.print(sb);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
    

