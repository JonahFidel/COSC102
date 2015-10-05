/*
 * Baby Database program
 * COSC 102, Colgate University
 *
 * Database interface
 * (c) 2014 Vijay Ramachandran
 */
 
import java.io.*;

public interface DataSet
{
    /* loads the data from the specified filename */
    public void load(String filename) throws FileNotFoundException, DataSetException;

    /* returns a new object, containing a copy of this data set */
    public DataSet copy();
    
    /* returns the number of active fields this data set has */
    public int getNumFields();
    
    /* returns the max number of characters used for field f,
       where 0 <= f < getNumFields() */
    public int getFieldLength(int f);
    
    /* returns the title of field f,
       where 0 <= f < getNumFields() */
    public String getFieldTitle(int f);
    
    /* returns the number of records this data set has */
    public int getNumRecords();
    
    /* returns the data contained in field f in record r,
       where 0 <= r < getNumRecords() and 0 <= f < getNumFields() */
    public String getRecordField(int r, int f);
    
    /* removes any records that do not also appear in other */
    public void intersect(DataSet other); 
    
    /* adds any records that appear in other */
    public void union(DataSet other);
    
    /* removes any records where the given field does not contain the search string */
    public void contains(String field, String search) throws DataSetException;
    
    /* removes any records where the given field does not start with the search string */
    public void starts(String field, String search) throws DataSetException;
    
    /* sets the number of active fields to be as many there are in the original data set */
    public void includeAll();
    
    /* sets the number of active fields to be zero */
    public void includeNone();
    
    /* sets the given field to be active */
    public void include(String field) throws DataSetException;
    
    /* does an ascending sort on the data, relative to the given field */
    public void asort(String field) throws DataSetException;
    
    /* does a descending sort on the data, relative to the given field */
    public void dsort(String field) throws DataSetException;
}