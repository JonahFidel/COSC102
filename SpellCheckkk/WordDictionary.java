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


public class WordDictionary extends Trie 
{

    // constructor
    public WordDictionary()
    {
        super(); 
    }
    
    TrieNode words = new TrieNode(); 

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
        LinkedList results = new LinkedList(); 
        TrieNode currNode = new TrieNode();
        
        while (results.size() < max) 
        {
          for (int i = 0; i < str.length(); i++)
          {
            // should check to see if characters match the characters of the Trie match the characters of the string 
            // any subTries with the string as their prefix will be added to the linkedlist (results.add(result)); 
            currNode = currNode.links.get(str.charAt(i)); // something close to this will iterate through the trie 
          }
        }
        
        if (results.size() == 0) return null; 
  
        return results;
        
    }
    
    // returns a Collection of Strings that are within _dist_ hamming
    // distance of the target string, up to _max_ Strings
    public Collection<String> findClosest(String str, int dist, int max)
    {
        str = str.trim().toLowerCase();
        LinkedList results = new LinkedList(); 
        // iterate through the trie in a similar fashion to the above function. Compare the distance between results
        // append to another LinkedList accordingly 
        
        if (results.size() == 0) return null; 
  
        return results;
        
    }
       
}
