//Jonah Fidel 
//2/18/14
//Lab 3 

import java.util.Scanner;

public class Guess
{
  public static void main(String[] args)
  {
    System.out.println("Enter a number corresponding to one of the following options:  1 - User guesses; 2 - Computer guesses; 3 - Quit.");
    Scanner scan = new Scanner(System.in);
    int typeOfOutput;
    typeOfOutput = scan.nextInt(); 
    while (typeOfOutput != 3)  // checks for quit input 
    {
      if (typeOfOutput == 1) // user guessing game 
      {
        System.out.println("What is the minimum of the range? "); 
        int low; 
        low = scan.nextInt(); 
        System.out.println("What is the maximum of the range? "); 
        int high; 
        high = scan.nextInt();
        int pick = ((int) ( Math.random() * (high - low + 1) )) + low;
        int guess = pick + 3; // ensures guess is not equal to pick initially 
        int guesses = 1; 
        while (guess != pick)
        {
          System.out.println("What is your guess? ");
          guess = scan.nextInt(); 
          if (guess < pick) 
          {
            System.out.println("Too low, guess higher. "); 
            guesses++;
          }
          if (guess > pick) 
          {
            System.out.println("Too high, guess lower. ");
            guesses++;
          }
          if (guess == pick)
          {
            System.out.println("You guessed correctly, you win! ");
            System.out.println("It took you " + guesses + " guesses to win!");
            System.out.println("Enter a number corresponding to one of the following options:  1 - User guesses; 2 - Computer guesses; 3 - Quit.");
            typeOfOutput = scan.nextInt(); 
          }
        }
      }
      if (typeOfOutput == 2)   // Computer guessing game 
        System.out.println("What is the minimum of the range? "); 
        int low; 
        low = scan.nextInt(); 
        System.out.println("What is the maximum of the range? "); 
        int high; 
        high = scan.nextInt();
        System.out.println("Choose a number in the range. ");
        int pick = scan.nextInt(); 
        System.out.println(pick);
        int guesses = 0; 
        int guess = ((int) ( Math.random() * (high - low + 1) )) + low;  // establishes random computer guess
        while (guess != pick)
        {
          System.out.println("The computer guessed " + guess + ".");
          System.out.println("Enter 1 if the guess is too high or 2 if the guess is too low. ");
          int set = scan.nextInt();
          if (set == 1) 
          {
            high = guess;
            guess = ((int) ( Math.random() * (high - low + 1) )) + low;  //adjusts range
            guesses++;
          }
          if (set == 2) 
          {
            low = guess;
            guess = ((int) ( Math.random() * (high - low + 1) )) + low;  //adjusts range
            guesses++;
          }
          else if (set != 1)  // accounts for invalid input 
            if (set != 2)
          {
            System.out.println("Invalid entry, try again. ");
            System.out.println("Enter 1 if the guess is too high or 2 if the guess is too low. ");
            set = scan.nextInt();
          }
        }
        if (guess == pick) 
        {
          guesses++;
          System.out.println("The computer guessed your number " + pick + " correctly in " + guesses + " guesses!");
          System.out.println("Enter a number corresponding to one of the following options:  1 - User guesses; 2 - Computer guesses; 3 - Quit.");   //reprompts user
          typeOfOutput = scan.nextInt();  
        }
      if (typeOfOutput == 3)
        break; 
      else if (typeOfOutput != 3)   //accounts for invalid entry 
        if (typeOfOutput != 2) 
          if (typeOfOutput != 1)
      {
        System.out.println("Invalid entry, try again. ");
        System.out.println("Enter a number corresponding to one of the following options:  1 - User guesses; 2 - Computer guesses; 3 - Quit.");
        typeOfOutput = scan.nextInt(); 
      }
    }
  }
}
