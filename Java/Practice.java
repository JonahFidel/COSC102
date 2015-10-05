// Quiz 3 Practice 

public class Node
{
  static int count(Node list, int n)
{
    int c = 0;
    for (Node current = list; current != null; current = current.next)
        if (current.item == n)
            c++;

    return c;
}
}