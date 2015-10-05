public class Rational 
{
  
  // Data 
  private int n; // numerator
  private int d; // denominator 
  
  // accessors 
  public int getNumerator()
  {
    return n; 
  }
  
  public int getDenominator()
  {
    return d;
  }
  
  private int gcd (int a, int b)
  {
    if (b > a) return gcd(b, a); 
    if (b == 0) return a; 
    return gcd(b, a % b);
  }
 
  
  // Constructors 
  // 1. no return type 
  // 2. name is same as the class 
  
  public Rational (int n, int d)
  {
    if (d == 0) 
      throw new ArithmeticException();
    
    if (d < 0) 
    {
      d = -d;
      n = -n; 
    }
    
    // reduce!
    
    int g = gcd(Math.abs(n), d);
    
    this.n = n/g; 
    this.d = d/g; 
  }
  
  public Rational(int n) 
  {
    this(n, 1); // calls the other constructor 
  }
  
  //toString 
  public String toString()
  {
    return n + "/" + d;
  }
  
  // let's add!
  public Rational add(Rational other)
  {
   int new_num = this.n * other.d + this.d * other.n; 
   int new_den = this.d * other.d; 
   
   Rational r = new Rational(new_num, new_den); 
   return r; 
  }
  
  public static Rational add(Rational r1, Rational r2)
  {
    return r1.add(r2); 
  }
  
}
