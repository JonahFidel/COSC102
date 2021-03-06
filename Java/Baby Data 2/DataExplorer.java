/*
 * Baby Database program
 * COSC 102, Colgate University
 * 
 * Query driver
 * THE ONLY MODIFICATION SHOULD BE MADE TO LINE 21
 * (c) 2014 Vijay Ramachandran
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataExplorer
{
    private static final String prog = "DataExplorer";

    // change the constructor call to the name of your class
    // use RefDataSet() for the reference implementation
    private DataSet ds_orig = new NewExplorer();
    private DataSet[] vars = new DataSet[5];
    private int line = 0;
    
    private DataExplorer(String filename)
    {
        try
        {
            ds_orig.load(filename);
        }
        catch (FileNotFoundException e)
        {
            System.err.println(prog + ": could not find datafile " + filename);
            System.exit(2);
        }
        catch (DataSetException e)
        {
            System.err.println(prog + ": error reading datafile " + filename);
            System.err.print("   ");
            System.err.println(e.getCustomMsg());
            System.exit(5);
        }
    }
        
    private DataSet copy()
    {
        return ds_orig.copy();
    }
    
    private int checkVar(String[] tokens, boolean null_check)
    {
        if (tokens.length >= 2)
        {
            int var = -1;
            try
            {
                var = Integer.parseInt(tokens[1]);
                if (var >= 0 || var <= 4)
                {
                    if (null_check && vars[var] == null)
                    {
                        System.err.print(prog);
                        System.err.print(": line ");
                        System.err.print(line);
                        System.err.print(", ");
                        System.err.print(tokens[0]);
                        System.err.println(" references undefined dataset");
                        return -1;
                    }
                    else
                        return var;
                }
            }
            catch (NumberFormatException e)
            {
                // fall through to print error message
            }
        }

        System.err.print(prog);
        System.err.print("(");
        System.err.print(line);
        System.err.print("): ");
        System.err.print(tokens[0]);
        System.err.println(" requires int var 0-4");
        return -1;
    }
    
    private static void printSpaces(int n)
    {
        while (n-- > 0)
            System.out.print(" ");
    }
    
    private static void printDashes(int n)
    {
        while (n-- > 0)
            System.out.print("-");
    }
    
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.err.println(prog + ": usage error; datafile required");
            System.exit(1);
            return;
        }
        
        DataExplorer de = new DataExplorer(args[0]);
        
        int active_var = -1;
        
        Scanner input = new Scanner(System.in);
        String[] tokens;
        while (input.hasNextLine())
        {
            de.line++;
            tokens = input.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < tokens.length; i++)
            {
                tokens[i] = tokens[i].replace("_", " ");
            }
            
            if (tokens.length < 1)
                continue;
                
            if (tokens[0].length() < 1)
                continue;
            
            if (active_var >= 0)
            {
                if (tokens[0].equals("end"))
                {
                    active_var = -1;
                }
                
                else if (tokens[0].equals("copy"))
                {
                    int var = de.checkVar(tokens, true);
                    if (var >= 0)
                        de.vars[active_var] = de.vars[var].copy();
                }
                
                else if (tokens[0].equals("intersect"))
                {
                    int var = de.checkVar(tokens, true);
                    if (var >= 0)
                        de.vars[active_var].intersect(de.vars[var]);
                }
                
                else if (tokens[0].equals("union"))
                {
                    int var = de.checkVar(tokens, true);
                    if (var >= 0)
                        de.vars[active_var].union(de.vars[var]);
                }
                
                else if (tokens[0].equals("contains"))
                {
                    if (tokens.length >= 3)
                    {
                        try {
                            de.vars[active_var].contains(tokens[1], tokens[2]);
                        } catch (DataSetException e) {
                            System.err.println(prog + "(" + de.line + "): error processing contains statement");
                            System.err.print("   ");
                            System.err.println(e.getCustomMsg());
                        }
                    }
                    else
                        System.err.println(prog + "(" + de.line + "): contains requires field and search string");
                }
                
                else if (tokens[0].equals("starts"))
                {
                    if (tokens.length >= 3)
                    {
                        try {
                            de.vars[active_var].starts(tokens[1], tokens[2]);
                        } catch (DataSetException e) {
                            System.err.println(prog + "(" + de.line + "): error processing starts statement");
                            System.err.print("   ");
                            System.err.println(e.getCustomMsg());
                        }
                    }
                    else
                        System.err.println(prog + "(" + de.line + "): starts requires field and search string");
                }
                
                else if (tokens[0].equals("include"))
                {
                    if (tokens.length >= 2)
                    {
                        de.vars[active_var].includeNone();
                        for (int i = 1; i < tokens.length; i++)
                        {
                            try {
                                de.vars[active_var].include(tokens[i]);
                            } catch (DataSetException e) {
                                System.err.println(prog + "(" + de.line + "): error processing include statement");
                                System.err.print("   ");
                                System.err.println(e.getCustomMsg());
                            }
                        }
                    } else
                        de.vars[active_var].includeAll();
                }
                
                else if (tokens[0].equals("asort"))
                {
                    if (tokens.length >= 2)
                    {
                        try {
                            de.vars[active_var].asort(tokens[1]);
                        } catch (DataSetException e) {
                            System.err.println(prog + "(" + de.line + "): error processing asort statement");
                            System.err.print("   ");
                            System.err.println(e.getCustomMsg());
                        }
                    }
                    else
                        System.err.println(prog + "(" + de.line + "): asort requires field");
                }
                
                else if (tokens[0].equals("dsort"))
                {
                    if (tokens.length >= 2)
                    {
                        try {
                            de.vars[active_var].dsort(tokens[1]);
                        } catch (DataSetException e) {
                            System.err.println(prog + "(" + de.line + "): error processing dsort statement");
                            System.err.print("   ");
                            System.err.println(e.getCustomMsg());
                        }
                    }
                    else
                        System.err.println(prog + "(" + de.line + "): dsort requires field");
                }

                else
                {
                    System.err.println(prog + "(" + de.line + "): syntax error");
                }
            }
            else
            {
                if (tokens[0].equals("begin"))
                {
                    int var = de.checkVar(tokens, false);
                    if (var >= 0)
                    {
                        active_var = var;
                        de.vars[active_var] = de.copy();
                    }
                }

                else if (tokens[0].equals("clear"))
                {
                    int var = de.checkVar(tokens, false);
                    if (var >= 0)
                        de.vars[var] = null;
                }

                else if (tokens[0].equals("print"))
                {
                    int var = de.checkVar(tokens, true);
                    if (var < 0)
                        continue;
                    
                    int[] width = new int[de.vars[var].getNumFields()];
                    String[] titles = new String[width.length];
                    String item;

                    System.out.println();
                    for (int f = 0; f < width.length; f++)
                    {
                        width[f] = de.vars[var].getFieldLength(f);
                        titles[f] = de.vars[var].getFieldTitle(f);
                        if (width[f] < titles[f].length())
                            width[f] = titles[f].length();
                        
                        System.out.print(titles[f]);
                        printSpaces(width[f] - titles[f].length());
                        printSpaces(2);
                    }
                    System.out.println();
                    for (int f = 0; f < width.length; f++)
                    {
                        printDashes(width[f]);
                        printSpaces(2);
                    }
                    System.out.println();
                    
                    for (int r = 0; r < de.vars[var].getNumRecords(); r++)
                    {
                        for (int f = 0; f < width.length; f++)
                        {
                            item = de.vars[var].getRecordField(r, f);
                            System.out.print(item);
                            printSpaces(width[f] - item.length());
                            printSpaces(2);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                
                else if (tokens[0].equals("exit"))
                {
                    break;
                }
                
                else
                {
                    System.err.println(prog + "(" + de.line + "): syntax error");
                    continue;
                }
            } // end of mode check
        } // end of line-by-line loop        
    } // end of main
} // end of class
