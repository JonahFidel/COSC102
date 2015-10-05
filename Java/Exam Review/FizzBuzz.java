public class FizzBuzz
{
    public static void main(String[] args)
    {
        /* -----------------------------------
        // while loop
        // nested if statements
        
        int n;
        
        n = 1;
        while (n <= 100) {
        
            if (n % 3 == 0) {
                if (n % 5 == 0)
                    System.out.println("FizzBuzz");
                else
                    System.out.println("Fizz");
            }
            else {
                if (n % 5 == 0) {
                    System.out.println("Buzz");
                }
                else {
                    System.out.println(n);
                }
            }
        }  // end of while loop
        
        ------------------------------------
        */
        
        // for loop version
        // else if statements with a boolean and operator
        
        for (int n = 1; n <= 100; n++) {
        
            if (n % 3 == 0 && n % 5 == 0)
                System.out.println("FizzBuzz");
                
            else if (n % 3 == 0)
                System.out.println("Fizz");
                
            else if (n % 5 == 0)
                System.out.println("Buzz");
                
            else
                System.out.println(n);

        }  // end of for loop
        
    }  // end of main
} // end of class FizzBuzz