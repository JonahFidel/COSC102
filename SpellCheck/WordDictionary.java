/* class WordDictionary
 *
 * COSC 102, Colgate University
 * 
 * YOU MUST IMPLEMENT THIS CODE.
 * DO NOT CHANGE ANY METHOD SIGNATURES.
 * 
 * Code for the Trie data structure to store the dictionary
 */

import java.io.*;
import java.util.*;


public class WordDictionary
{

    // constructor
    public WordDictionary()
    {
        super();
    }
    
    Trie words = new Trie(); 


    // adds a word to the dictionary
    // returns true if added;  false if already there (or a problem)
    public boolean add(String str)
    {
        str = str.trim().toLowerCase();
        words.add(str);
        
        return false;
        
    }
    
    // returns a Collection of Strings containing words that begin
    // with the prefix str, up to _max_ Strings
    public Collection<String> getCompletions(String str, int max)
    {
        str = str.trim().toLowerCase();
  
        return null;
        
    }
    
    // returns a Collection of Strings that are within _dist_ hamming
    // distance of the target string, up to _max_ Strings
    public Collection<String> findClosest(String str, int dist, int max)
    {
        str = str.trim().toLowerCase();
  
        return null;
        
    }
       
}
