// Program 

import java.util.Scanner;

public class Program
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter your name:");
        String s = scan.nextLine();
        System.out.print("Your name is ");
        System.out.println(s);
        
    }
}