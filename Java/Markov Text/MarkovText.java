// Jonah Fidel 
// 4/23/14
// Comp Sci 102
// Markov Text in lab Assignment 

import java.util.*;
import java.io.*;

public class MarkovText 
{
  public static void main(String args[])
  {
    File filename = new File(args[0]); // filename is the first command line argument
    int N = Integer.parseInt(args[1]); // set size 
    int sentences = Integer.parseInt(args[2]); // number of sentences
    
//    System.out.println(N); 
//    System.out.println(sentences); 
    
    HashMap<ArrayList, ArrayList> words = new HashMap<ArrayList, ArrayList>(); 
    ArrayList<String> enders = new ArrayList<String>(); // contains all sentence enders
    
//    String hello = new String("Hi there how are you?"); 
//    System.out.println(hello.length()); 
    
    try {
      Scanner scan = new Scanner(filename); 
      while (scan.hasNext())
      {
        int idx = 0; 
        String line = scan.nextLine(); 
        String[] parse = line.trim().split(" ");
        
        ArrayList sentence = new ArrayList(); 
        for (int i = 0; i < parse.length; i++)
        {
          String str = parse[i]; 
          for (int k = 0; k < str.length(); k++)
          {
            if (str.charAt(k) == '.') 
            {
              enders.add(str.toString()); 
            }
          }
        }
      }
    }
    catch (FileNotFoundException E) {
      System.err.println("File not found. "); 
    }
    // System.out.println(enders); 
  } 
}