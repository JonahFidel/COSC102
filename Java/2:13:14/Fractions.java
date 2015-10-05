public class Fractions
{
  public static void main(String[] args) 
  {
    Rational r; 
    r = new Rational(4, 3); 
    
    Rational r2 = new Rational(5, -3);
    
    System.out.println(Rational.add(r, r2)); 
  }
}
