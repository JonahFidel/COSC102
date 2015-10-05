import java.util.*;  

public class TrieNode 
{     
  public TrieNode()   
  {    
    super();    
  }   
  boolean exists = true;    
  HashMap<Character, TrieNode> links = new HashMap <Character, TrieNode>();        
  TrieNode root = new TrieNode();          
  public boolean add(String word) 
  {             
    if (lookup(word) == true) return false;       
    else 
    {        
      for (int i = 0; i <= word.length(); i++)       
      {           
        TrieNode currNode = new TrieNode();            
        links.put(word.charAt(i), currNode);           
        currNode = currNode.links.get(word.charAt(i));        
      }         
      return true;       
    }     
  }          
  public boolean lookup(String word) 
  {       
    TrieNode n = root;        
    for (int i = 0; i < word.length(); i++)      
    {         
      n = n.links.get(word.charAt(i));        
      if (n == null) n.exists = false;       
    }       
    return n.exists;     
  }  
} 