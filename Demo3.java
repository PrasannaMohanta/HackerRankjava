import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Demo3 {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
        String n = "";
        if (N%2==1){
            n = "Weird";
        }
        else{
            if(N>=2 && N<=5){
                n = "Not Weird";
            }
            else if(N>=6 && N<=20){
                n ="Weird";
            }else {
                n = "Not Weird";
                
            }
        }
       System.out.println(n);  
    }
   
}
