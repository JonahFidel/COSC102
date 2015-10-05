// Jonah Fidel 
// 4/15/14
// Comp Sci 102 
// myQueue in lab assignment

public class myQueue
{ 
  Node head; 
  Node tail;
  int size = 0; 
  private class Node
  {
    String item; 
    Node next; 
    public Node(String item) 
    {
      this.item = item; 
    }
  }
  public void add(String s)
  {
    
    Node newNode = new Node(s); 
    
    if (head == null) 
    {
      head = newNode;
      size++; 
    }
    
    else if (head.next == null) 
    { 
      head.next = newNode;
      size++; 
    }
    else{
      for (Node n = head; n != null; n = n.next)
      {
        if (n.next == null) 
        {
          n.next = newNode = tail;
          size++; 
        }
      }
    }
  }
  
  
  public String remove()
  {
    if (this.size() == 0) 
      return null; 
    else {
      String s = head.item; 
      if (this.size == 1)
        head = null; 
      else {
        head = head.next;
      }
      size--; 
      return s; 
    }
  }
  public void concat(myQueue q)
  {
    if (q.size > 0) 
    {
      Node x = q.head.next;
      String s = q.remove(); 
      this.add(s); 
      this.head.next = x; 
      size = size + q.size;
      return;
    }
  }
  
  public int size()
  {
    return size; 
  }
  
  public static void main(String[] args)
  {
    myQueue m = new myQueue();  
    
    m.add("first");
    m.add("second");
    m.add("third"); 
    m.add("fourth"); 
   
    int x = m.size(); 
    
    System.out.println(x); 
   
    System.out.println(m.head.item); 
    
    myQueue z = new myQueue(); 
    
    z.add("fifth"); 
    z.add("sixth"); 
    z.add("seventh"); 
    
    z.concat(m); 
 
    System.out.print(z.size); 
  }
}