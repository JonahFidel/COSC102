// Jonah Fidel 
// 5/1/14
// Comp Sci 102 
// Spell Check Lab 

import java.util.*; 

public class Trie extends TrieNode
{
  TrieNode root = new TrieNode(); 
  public boolean lookup(String word) 
  {
    TrieNode n = root; 
    for (int i = 0; i < word.length(); i++)
    {
      n = n.links.get(word.charAt(i)); 
      if (n == null) return false; 
    }
    return n.exists; 
  }
}