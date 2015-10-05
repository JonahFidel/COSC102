/*
 * Baby Database program
 * COSC 102, Colgate University
 *
 * Dataset Error
 * YOU SHOULD NOT MODIFY THIS FILE
 * (c) 2014 Vijay Ramachandran
 */

public class DataSetException extends Exception
{
    private String custom_msg;

    public DataSetException()
    {
        super();
        custom_msg = "";
    }
    
    public DataSetException(String error)
    {
        super(error);
        custom_msg = error;
    }
    
    public String getCustomMsg()
    {
        return custom_msg;
    }
}
