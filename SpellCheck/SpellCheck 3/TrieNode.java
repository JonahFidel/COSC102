// Jonah Fidel 
// Comp Sci 102 
// SpellCheck Lab 
// TrieNode Class 

import java.util.*; 

public class TrieNode 
{
  public TrieNode ()
  {
    char value; 
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>(); 
    boolean fullWord = false; 
  }
  public HashMap<Character, TrieNode> getChildren() {return children;}
  public char getValue() {return value;}    
  public void setEnd(boolean val) {fullWord = val;}    
  public boolean isEnd() {return fullWord;}
  
  private char value; 
  private HashMap<Character, TrieNode> children; 
  private boolean fullWord; 
}