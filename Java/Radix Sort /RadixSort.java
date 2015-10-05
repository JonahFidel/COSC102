// Jonah Fidel 
// 4/13/14
// Comp Sci 102 
// Radix Sort Lab 

import java.util.Scanner; 
import java.io.*;

public class RadixSort 
{
  public static void main(String[] args)
  {
    String input_filename = args[0]; 
    String output_filename = args[1];
    
    File output = new File(output_filename); 
    File input = new File(input_filename); 
    
    myQueue mainQueue = new myQueue(); 
    
    try
    {
      PrintStream ps = new PrintStream(output); 
      Scanner sc = new Scanner(input); 
      
      myQueue empty = new myQueue(); 
      myQueue a = new myQueue(); 
      myQueue b = new myQueue(); 
      myQueue c = new myQueue(); 
      myQueue d = new myQueue();
      myQueue e = new myQueue(); 
      myQueue f = new myQueue(); 
      myQueue g = new myQueue();
      myQueue h = new myQueue(); 
      myQueue i = new myQueue(); 
      myQueue j = new myQueue(); 
      myQueue k = new myQueue(); 
      myQueue l = new myQueue(); 
      myQueue m = new myQueue(); 
      myQueue n = new myQueue(); 
      myQueue o = new myQueue(); 
      myQueue p = new myQueue(); 
      myQueue q = new myQueue(); 
      myQueue r = new myQueue(); 
      myQueue s = new myQueue();
      myQueue t = new myQueue(); 
      myQueue u = new myQueue(); 
      myQueue v = new myQueue(); 
      myQueue w = new myQueue(); 
      myQueue x = new myQueue(); 
      myQueue y = new myQueue();
      myQueue z = new myQueue(); 
      
      while (sc.hasNextLine()) 
      {
        mainQueue.add(sc.nextLine()); 
      }
      
      System.out.println(mainQueue.size()); 
      
      for (int ii = 0; ii <= 11; ii++) // accounts for each of 12 characters per word 
      {
        while (mainQueue.size() > 0)
        {
          String currLine = mainQueue.remove(); // This line keeps having a nullPointerException... I can't figure out why. 
          try {
            char currChar = currLine.charAt(ii); 
            if (currChar == 'a') a.add(currLine); // sorts words into individual buckets 
            if (currChar == 'b') b.add(currLine); 
            if (currChar == 'c') c.add(currLine); 
            if (currChar == 'd') d.add(currLine);
            if (currChar == 'e') e.add(currLine);
            if (currChar == 'f') f.add(currLine);
            if (currChar == 'g') g.add(currLine);
            if (currChar == 'h') h.add(currLine);
            if (currChar == 'i') i.add(currLine);
            if (currChar == 'j') j.add(currLine);
            if (currChar == 'k') k.add(currLine);
            if (currChar == 'l') l.add(currLine);
            if (currChar == 'm') m.add(currLine);
            if (currChar == 'n') n.add(currLine);
            if (currChar == 'o') o.add(currLine);
            if (currChar == 'p') p.add(currLine);
            if (currChar == 'q') q.add(currLine);
            if (currChar == 'r') r.add(currLine);
            if (currChar == 's') s.add(currLine);
            if (currChar == 't') t.add(currLine);
            if (currChar == 'u') u.add(currLine);
            if (currChar == 'v') v.add(currLine);
            if (currChar == 'w') w.add(currLine);
            if (currChar == 'x') x.add(currLine);
            if (currChar == 'y') y.add(currLine);
            if (currChar == 'z') z.add(currLine);
          }
          catch(StringIndexOutOfBoundsException S) {
            System.err.print(S); 
            empty.add(currLine);
          }
          
        }
        if (empty.size > 0) mainQueue.concat(empty); // adds individual buckets back to the main queue
        if (a.size > 0) mainQueue.concat(a); 
        if (b.size > 0) mainQueue.concat(b);
        if (c.size > 0) mainQueue.concat(c);
        if (d.size > 0) mainQueue.concat(d);
        if (e.size > 0) mainQueue.concat(e);
        if (f.size > 0) mainQueue.concat(f);
        if (g.size > 0) mainQueue.concat(g); 
        if (h.size > 0) mainQueue.concat(h); 
        if (i.size > 0) mainQueue.concat(i); 
        if (j.size > 0) mainQueue.concat(j); 
        if (k.size > 0) mainQueue.concat(k);
        if (l.size > 0) mainQueue.concat(l);
        if (m.size > 0) mainQueue.concat(m);
        if (n.size > 0) mainQueue.concat(n);
        if (o.size > 0) mainQueue.concat(o);
        if (p.size > 0) mainQueue.concat(p); 
        if (q.size > 0) mainQueue.concat(q);
        if (r.size > 0) mainQueue.concat(r); 
        if (s.size > 0) mainQueue.concat(s); 
        if (t.size > 0) mainQueue.concat(t); 
        if (u.size > 0) mainQueue.concat(u);
        if (v.size > 0) mainQueue.concat(v); 
        if (w.size > 0) mainQueue.concat(w); 
        if (x.size > 0) mainQueue.concat(x); 
        if (y.size > 0) mainQueue.concat(y);
        if (z.size > 0) mainQueue.concat(z);
      }
//      
//      int aa = a.size(); 
//      int bb = b.size(); 
//      int emptysize = empty.size(); 
//      System.out.println(aa);
//      System.out.println(bb); 
//      System.out.println(emptysize); 
//      System.out.println(c.size()); 
//      System.out.println(mainQueue.size); 
      
      while (mainQueue.size > 0)   // adds to printstream
      {
        String item = mainQueue.remove();
        ps.println(item); 
      }
      
      ps.close(); 
    }
    
    catch(FileNotFoundException E)
    {
      System.err.println(E); 
    } 
  }
}
