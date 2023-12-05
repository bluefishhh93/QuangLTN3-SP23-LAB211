
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Calculate {
    public List<Float>calculateEquation (float a, float b){
        List<Float> number = new ArrayList<>();
        if(a==0&&b!=0)
            return null;
        if(a==0&&b==0)
            return number;
        if(a!=0){
            number.add(-b/a);
            number.add(a);
            number.add(b);            
        }
 
        return number;
    }
    
    public List<Float> calculateQuadraticEquation(float a, float b, float c){
        List<Float> number = new ArrayList<>();
        float delta = b*b-4*a*c;
        if(a==0&&b==0&&c==0)
            return number;
        if(delta<0)
            return null;
        else if(delta == 0){
            number.add(-b/(2*a));
            number.add(-b/(2*a));
            number.add(a);
            number.add(b);
            number.add(c);
        }
        else{
            number.add((float)(-b-Math.sqrt(delta))/(2*a));
            number.add((float)(-b+Math.sqrt(delta))/(2*a));
            number.add(a);
            number.add(b);
            number.add(c);
        }
        return number;
    }
    
    
}
