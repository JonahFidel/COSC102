//Jonah Fidel 
//3/4/14
//Comp Sci 102 

public class Echo
{
//  public static String title(String s)     // couldn't get this helper to work
//  {
//    String str;
//    for (int i = 0; i < s.length(); i++)
//    {
//      if (Character.isLetter(s.charAt(i)))
//        str = s.substring(0, i + 1).toUpperCase() + s.substring(i + 1).toLowerCase();
//      return str;
//    }
  public static void main(String[] args)
  {
    char Mode = 'n'; 
    for (int i = 0; i < args.length; i++)
    {
      
      if (args[i] == "-r")
        System.out.println("");
      else if (args[i] == "--")
        System.out.println(args[i].substring(1) + " ");
      
      else if (args[i] == "-n")
        Mode = 'n';
      else if (args[i] == "-c") 
        Mode = 'c';
      else if (args[i] == "-u")
        Mode = '
      else if (args[i] == "-l") 
        Mode = 'l'; 
      else if (args[i] == "-t")
        Mode = 't';
      else
      {
        if (Mode == 'c') 
          System.out.print(args[i].length() + " ");
        if (Mode == 'l') 
          System.out.print(args[i].toLowerCase() + " "); 
        if (Mode == 'u') 
          System.out.print(args[i].toUpperCase() + " ");
        if (Mode == 'n') 
          System.out.print(args[i] + " ");
//        if (Mode == 't') 
//          System.out.print(title(args[i]) + " ");
      }
    }
  }
}
