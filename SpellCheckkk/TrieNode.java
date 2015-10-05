import java.util.*; 

public class TrieNode 
{
  boolean exists = true; 
  HashMap<Character, TrieNode> links = new HashMap<Character, TrieNode>(); 
    
  public TrieNode() 
  {
    boolean fullWord; 
  }
  
  TrieNode root = new TrieNode(); // can't figure out how to fix stack overflow error 
  
  public boolean add(String word) 
  {
    TrieNode currNode = root; 
    if (lookup(word) == true) return false; // returns false if the word is already in the dictionary 
    else 
    {
      for (int i = 0; i < word.length(); i++) 
      {
        if (currNode.links.get(word.charAt(i)) == null)  // determines if an entry already exists for a given character 
        {
          currNode.links.put(word.charAt(i), currNode); 
        }
        currNode = currNode.links.get(word.charAt(i + 1)); // iterates to the next node (character) in a given word 
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

