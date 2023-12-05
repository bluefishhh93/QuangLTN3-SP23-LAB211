
import java.util.Scanner;

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
     private static int inputBase(String msg1,String msg2){
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            try {
                System.out.println(msg1);
                 n = Integer.parseInt(sc.nextLine());
                 if(n>=1&&n<=3){
                     if(n==1){
                         return 2;
                     }else if(n==2){
                         return 10;
                     }else if(n==3){
                         return 16;
                     }
                 }
                 else System.out.println("the choice must be in [1,3]");
            } catch (Exception e) {
                System.out.println(msg2);
            } 
        }while(true);
    } 
     
     private static String BaseToBase(String num, int base1, int base2){
         int no = BaseToDec(num, base1);
         return DecToBase(no, base2);
         
     }
     
     private static int BaseToDec(String num, int base) {
        if(base < 2 || (base > 10 && base != 16))
            return -1;
        int val = 0;
        int power = 1;
        for(int i = num.length()-1; i>= 0; i--){
         int digit = digitToVal(num.charAt(i));
         if(digit < 0 || digit >= base)
             return -1;
         val += digit * power;
         power = power*base;
     }
        return val;
    }

    private static String DecToBase(int num, int base) {
        String res = "";
        int rem;
        while(num > 0){
            rem = num % base;
            if(base == 16){
                if(rem == 10){
                    res += 'A';
                }else if(rem == 11){
                    res += 'B';
                }else if(rem == 12){
                    res += 'C';
                }else if(rem == 13){
                    res += 'D';
                }else if(rem == 14){
                    res += 'E';
                }else if(rem == 15){
                    res += 'F';
                }
            }else res += rem;
            num = num / base;
        }
        return new StringBuffer(res).reverse().toString();
    }
     
    private static int digitToVal(char c){
        if(c>='0' && c <= '9')
        return (int) c - '0';
        else 
        return (int) c- 'A' +10;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 is binary, 2 is decimal,  3 is hexadecimal");
        int base1 = inputBase("Enter base number input: ", "Invalid base number input!");
        System.out.println("1 is binary, 2 is decimal,  3 is hexadecimal");
        int base2 = inputBase("Enter base number output", "Invalid base number output!");
        System.out.println("Enter value to convert");
        String num = sc.nextLine();
        System.out.println(BaseToBase(num, base1, base2));
        
        
        
    }

    
    
}
