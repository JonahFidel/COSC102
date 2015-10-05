import java.util.*;

public class Trie
{
  HashMap<Character, HashMap> root; 
  public Trie() 
  {
    root = new HashMap<Character, HashMap>(); 
  }
  
   public void add(String s) {
        HashMap<Character, HashMap> curr_node = root;
        for (int i = 0, n = s.length(); i < n; i++) {
            Character c = s.charAt(i);
            if (curr_node.containsKey(c))
                curr_node = curr_node.get(c);
            else {
                curr_node.put(c, new HashMap<Character, HashMap>());
                curr_node = curr_node.get(c);
            }
        }
        curr_node.put('\0', new HashMap<Character, HashMap>(0)); // term
    }
   public boolean contains(String s) {
        HashMap<Character, HashMap> curr_node = root;
        for (int i = 0, n = s.length(); i < n; i++) {
            Character c = s.charAt(i);
            if (curr_node.containsKey(c))
                curr_node = curr_node.get(c);
            else 
                return false;
        }
        if (curr_node.containsKey('\0'))
            return true;
        else 
            return false; 
    }
}