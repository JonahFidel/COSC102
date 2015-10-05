// Jonah Fidel 
// 3/4/14
// Comp Sci 102
// Lab 6

import java.util.Scanner;
import java.io.*; 
import java.util.ArrayList;

public class Volatility
{
  public static void main(String[] args) 
  {
    if (args.length < 1)
    {
      System.err.println("Volatility error: keyword argument needed! ");
      return;
    }
    
    Scanner scan = null;
    String filename = args[0]; 
    
 
    try
    {
      scan = new Scanner(new File(filename));
    }
    catch(FileNotFoundException e) 
    {
      System.err.println("Volatility error: could not open " + filename);
      return;
    }
    
    
    int D = 0; 
    double sum = 0;
    ArrayList<Double> list = new ArrayList<Double>();
    String notline = scan.nextLine();
    while (scan.hasNextLine())
    {
      String line = scan.nextLine();
      String[] cols = line.split(",");
      if (cols.length != 6) 
      {
        System.err.println("The file does not contain the correct number of columns. ");          
        return;
      }
      for (int i = 1; i < cols.length; i++)
      {
        try 
        {
          Double.parseDouble(cols[i]);
        }
        catch(NumberFormatException nfe) 
        {
          System.err.println("The file contains column data that is non-numeric. ");
          return;
        }
      }
      double open = Double.parseDouble(cols[1]); 
      double finish = Double.parseDouble(cols[4]); 
      double R = Math.log(finish/open);
      list.add(R);
      sum += R; 
      D++;
    }
    double M = sum/D; 
    double ssd = 0; 
    for (int i = 1; i < list.size(); i++)
    {
      double sd = Math.pow(list.get(i) - M, 2); 
      ssd += sd;
    }
    double stdv = Math.sqrt(ssd/(D - 1));
    double volatility = stdv * Math.sqrt(252); 
    System.out.println(volatility); 
  }
}
