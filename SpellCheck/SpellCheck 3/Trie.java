// Jonah Fidel 
// Comp Sci 102 
// SpellCheck Lab 
// Trie Class

import java.util.*; 

public class Trie extends TrieNode {        
    
    TrieNode root = new TrieNode();
   
    public boolean add(String word)  {
            
        TrieNode currNode = root;
           
        if (lookup(word) == true) return false; 
        else {
        for(int i = 0; i < word.length(); i++)
        {
            HashMap<Character,TrieNode> child = currNode.getChildren();            
            char ch = word.charAt(i);
               
            if(child.containsKey(ch))
                currNode = child.get(ch);
            else   
            {              
                TrieNode newNode = new TrieNode();
                child.put(ch, newNode);
                currNode = newNode;
            }
        }
        }
        currNode.setEnd(true);
        return true; 
    }
    public boolean lookup(String word) 
  {
    TrieNode n = root; 
    for (int i = 0; i < word.length(); i++) 
    {
      if (n.getChildren() != null)
      {n = n.getChildren().get(word.charAt(i)); }
      if (n == null) return false;
    }
    return n.isEnd(); 
  }
}