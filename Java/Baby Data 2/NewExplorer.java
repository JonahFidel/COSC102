// Jonah Fidel 
// 3/31/14
// Comp Sci 102 

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList; 

public class NewExplorer implements DataSet
{
  private ArrayList<String[]> matrix = new ArrayList<String[]>(); 
  private boolean activeFields[]; 
  private int numFields; 
  private int records; 
  private int fieldlength; 
  private String fieldName; 
  private String[] fields;
  
  public void load(String filename) throws FileNotFoundException, DataSetException
  { 
    Scanner scan = new Scanner(new File(filename));
    String firstline = scan.nextLine().trim(); 
    fields = firstline.split(";");
    numFields = fields.length; 
    
    int count = 0; 
    
    while (scan.hasNextLine())
    {
      String currentline = scan.nextLine().trim(); 
      String[] line = currentline.split(";");
      
      if (line.length > fields.length)
        throw new DataSetException();
      
      // for (int i = 0; i < line.length; i++) 
      //    System.out.print(line[i] + " ");
      // System.out.println();
      
      
      matrix.add(count, line);
      count++;
    } 
    activeFields = new boolean[count];
//    for (int i = 0; i < matrix.size(); i++) 
//    {
//      String[] strings = matrix.get(i);
//      for (int j = 0; j < strings.length; j++) 
//        System.out.print(strings[j] + " ");
//      System.out.println(); 
//    }
  }
  
  /* returns a new object, containing a copy of this data set */
  public DataSet copy()
  {
    return null;
  }
  
  /* returns the number of active fields this data set has */
  public int getNumFields()
  {
    int count = 0; 
    for (int i = 0; i < activeFields.length; i++) 
    {
      if (activeFields[i])
        count++; 
    }
    return count; 
  }
  
  /* returns the max number of characters used for field f,
   where 0 <= f < getNumFields() */
  public int getFieldLength(int f)
  {
    int maxlength = 0; 
    
    // loop through field, find longest data point 
    
    return maxlength; 
  }
  
  /* returns the title of field f,
   where 0 <= f < getNumFields() */
  public String getFieldTitle(int f)
  {
    return fields[f];
  }
  
  /* returns the number of records this data set has */
  public int getNumRecords()
  {
    // find depth of an individual field 
    
    return 0;
  }
  
  /* returns the data contained in field f in record r,
   where 0 <= r < getNumRecords() and 0 <= f < getNumFields() */
  public String getRecordField(int r, int f)
  {return null;}
  
  /* removes any records that do not also appear in other */
  public void intersect(DataSet other) 
  {}
  
  /* adds any records that appear in other */
  public void union(DataSet other)
  {}
  
  /* removes any records where the given field does not contain the search string */
  public void contains(String field, String search) throws DataSetException
  {}
  
  /* removes any records where the given field does not start with the search string */
  public void starts(String field, String search) throws DataSetException
  {}
  
  /* sets the number of active fields to be as many there are in the original data set */
  public void includeAll()
  { 
    for (int i = 0; i < activeFields.length; i++) 
    {
      activeFields[i] = true; 
    }
  }
  
  /* sets the number of active fields to be zero */
  public void includeNone()
  {
    for (int i = 0; i < activeFields.length; i++) 
    {
      activeFields[i] = false; 
    }
  }
  
  /* sets the given field to be active */
  public void include(String field) throws DataSetException
  {}
  
  /* does an ascending sort on the data, relative to the given field */
  public void asort(String field) throws DataSetException
  {}
  
  /* does a descending sort on the data, relative to the given field */
  public void dsort(String field) throws DataSetException
  {}
}