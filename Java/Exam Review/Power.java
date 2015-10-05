import java.util.Scanner;

public class Power
{

    /* First version of power
    
        This version is written as a while loop.
        Here, we multiply the base over and over again, exp times, to obtain the result.
        
        This version is O(exp), linear in the value of the exponent.
        
    */
    
    private static int power_slower(int base, int exp)
    {
        int answer = 1;
        
        while (exp > 0) {
            answer *= base;
            exp--;
        }
            
        return answer;
    }
    
    
    /* Second version of power
    
        This version is written recursively.
        Here, we divide the exponent by 2 and square the result of the subproblem,
        doing one extra multiply in the case that the exponent is odd.
        
        This version is O(log(exp)), logarithmic in the value of the exponent.
        
    */
    
    private static int power_faster(int base, int exp)
    {
        if (exp <= 0)
            return 1;
            
        int answer = power_faster(base, exp/2); // this is integer division by 2
        answer *= answer;                       // square the answer to the subproblem
        
        if (exp % 2 == 1)                       // if the exponent is odd...
            answer *= base;                     // ... include another factor of base
        
        return answer;
    }


    /* Main function
    
        This does keyboard input and console output.
        
    */

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the base: ");
        int base = scan.nextInt();
        
        System.out.print("Enter the exponent: ");
        int exp = scan.nextInt();
        
        System.out.print("The answer (slow version) is: ");
        System.out.println( power_slower(base, exp) );

        System.out.print("The answer (fast version) is: ");
        System.out.println( power_faster(base, exp) );

    } // end of main

}