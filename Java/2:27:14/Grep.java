import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;

public class Grep
{
  public static void main(String[] args)
  {
    if (args.length < 1) 
    {
      System.err.println("Grep error: keyword needed.");
      return;
    }
    
    String keyword = args[0];
    
    for(int i = 1; i < args.length; i++)
    {
      String filename = args[i];
      
      Scanner sc;
      try 
      {
        sc = new Scanner(new File(filename));
      }
      catch(FileNotFoundException e)
      {
        System.err.println("Could not open file.");
        return;
      }
      
      int num = 0; 
      
      while(sc.hasNextLine())
      {
        String line = sc.nextLine();
        num++;
        if (line.indexOf(keyword) >= 0)
          System.out.println(filename + "(" + num + "): " + line);
      }
    }
  }
}