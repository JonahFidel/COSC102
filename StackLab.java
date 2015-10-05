// Jonah Fidel 
// 4/1/14
// Comp Sci 102 
// Lab: Stack Excercises 

import java.util.Stack;

public class StackLab
{
//  public static void main(String[] args) // Main function for testing
//  {
//    Stack s; 
//    s = new Stack(); 
//    s.push(1); 
//    s.push(2); 
//    s.push(3); 
//    s.push(4); 
//    s.push(5); 
//    System.out.print(stackCopy(s));
//    System.out.print(s); 
//    System.out.print(stackReverse(s)); 
//    System.out.print(s); 
//  }
  public static <T> Stack<T> stackCopy(Stack<T> s)
  {
    Stack<T> newStack = new Stack<T>();
    Stack<T> helperStack = new Stack<T>(); 
    while (s.empty() == false) // Makes sure the original stack still contains data 
    {
      helperStack.push(s.pop()); // Removes item from s and adds to helper 
    }
    while (helperStack.empty() == false)
    {
      T n = helperStack.pop(); 
      newStack.push(n);         // push n back to the original stack and to the copy 
      s.push(n); 
    }
    // System.out.print(newStack);
    return newStack; 
  }
  
  public static <T> Stack<T> stackReverse(Stack<T> s)
  {
    Stack<T> newStack = new Stack<T>();
    Stack<T> helperStack = new Stack<T>(); 
    while (s.empty() == false) 
    {
      T n = s.pop();     // removes top data from original stack and stores as variable n 
      newStack.push(n); 
      helperStack.push(n);  // push n to the newStack and the helperStack 
    }
    while (helperStack.empty() == false) 
    {
      s.push(helperStack.pop()); // removes items from helperStack and pushes back to the original stack 
    }
    return newStack;
  }
}


