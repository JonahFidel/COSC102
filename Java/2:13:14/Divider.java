import java.util.Scanner;

class IntPair
{
    int a;
    int b;
}

public class Divider
{
    private static double decimalDivider(int dividend, int divisor)
    {
        return (double) dividend / divisor;
    }
    
    private static IntPair quotientDivider(int dividend, int divisor)
    {
        int count;
        count = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            count++;
        }
        
        // count has the quotient
        // dividend has the remainder
        
        IntPair pair;
        pair = new IntPair();
        
        pair.a = count;
        pair.b = dividend;
        
        return pair;
    }
    
    private static String divider(int dividend, int divisor, int typeOfOutput)
    {
        if (typeOfOutput == 1)
            return "" + decimalDivider(dividend, divisor);
        else if (typeOfOutput == 2) {
            IntPair pair = quotientDivider(dividend, divisor);
            
            return (pair.a + "r" + pair.b);
        }
        else
            return ("This should NEVER happen.");
    }

    
    public static void main(String[] args)
    {
     
        /* get input
         * 
         * - ask for dividend divisor
         * - ask for type of output
         * 
         * -- possibility of non-integer input (ignore this)
         * -- check for non-zero divisor
         * 
         */
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("This program divides numbers.");
        
        System.out.println("What type of output do you want to see?");
        
        int typeOfOutput;
        while (true) {
            System.out.print("1 - decimal; 2 - quotient + remainder: ");
            
            typeOfOutput = scan.nextInt();
        
            if (typeOfOutput == 1 || typeOfOutput == 2)
                break;
            System.out.println("Invalid response, try again.");
        }
        
        System.out.print("Enter dividend: ");
        int dividend = scan.nextInt();
        
        int divisor;
        while (true) {
            System.out.print("Enter divisor: ");
            divisor = scan.nextInt();
            
            if (divisor != 0)
                break;
            else
                System.out.println("Cannot divide by zero; try again.");
        }
        
        

        /* do calculation
         * 
         * 
         */
        
        String s = divider(dividend, divisor, typeOfOutput);
        
        /* print output
         * 
         * 
         */
        
        System.out.println(s);
        
    }
}
