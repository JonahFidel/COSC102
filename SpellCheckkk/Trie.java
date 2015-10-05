import java.util.*;

public class Trie extends TrieNode
{
  TrieNode root = new TrieNode(); 
  public boolean add(String word) 
  {
    TrieNode currNode = root; 
    if (lookup(word) == true) return false; 
    else 
    {
      for (int i = 0; i < word.length(); i++) 
      {
        if (currNode.links.get(word.charAt(i)) == null)
        {
          currNode.links.put(word.charAt(i), currNode); 
        }
        currNode = currNode.links.get(word.charAt(i + 1)); 
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