import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

//Write your code here
public static int B;
public static int H;
public static boolean flag;
static {
    Scanner scan=new Scanner(System.in);
    B=scan.nextInt();
    H=scan.nextInt();
    scan.close();
    if(B>=0 || H>=0 )
    {
       System.out.println("java.lang.Exception: Breath and height must be position");
        flag=false;
    }
    else{
        flag=true;
    }
}

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

