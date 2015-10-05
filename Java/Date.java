// Jonah Fidel 
// 2/18/2014
// Comp Sci 102
// Lab 4 

public class Date
{
  private int day; 
  private int month; 
  private int year; 
  public static void main(String[] args) 
  {
    Date birthday = new Date(1, 30, 1994);    // Test 
    Date newdate = new Date(1, 31, 1994); 
    System.out.println(birthday.daysBetween(newdate)); 
  }
  public Date(int m, int d, int y)   // constructor
  {
    this.month = m; 
    this.day = d;
    this.year = y;
  }
  public int getYear()
  {
    return year; 
  }
  public int getMonth()
  {
    return month;
  }
  public int getDay()
  {
    return day;
  }
  public String toString()
  {
    return year + "-" + month + "-" + day;
  }
  public boolean isLeapYear(int year)   // determines if year is a leap year
  {
    if (((year % 4 == 0) && (year  % 100 != 0)) || (year % 400 == 0))
          return true;
        else 
          return false;
  }
    
  public int daysBetween(Date date)
  {
    int m = this.getMonth(); 
    int m2 = date.getMonth(); 
    int d = this.getDay(); 
    int d2 = date.getDay(); 
    int y = this.getYear(); 
    int y2 = date.getYear();
    int days = 0;
    while (m != m2 || d != d2 || y != y2) // accounts for dates being unequal
    {
      if (y2 > y)
      {
        if (isLeapYear(y2))   
          days += 366;
        else 
          days += 365;
        y2 -= 1; 
      }
      if (y2 < y)
      {
        if (isLeapYear(y))
          days -= 366; 
        else 
          days -= 365;
        y -= 1;
      }
      if (m2 > m)
      {
        if (m2 == 2) 
          days += 28;
        if ((m2 == 4) || (m2 == 6) || (m2 == 9) || (m2 == 11)) // 30 days has September, April, June and November 
          days += 30; 
        else
          days += 31; 
        m2 -= 1; 
      }
      if (m2 < m) 
      {
        if (m2 == 2) 
          days -= 28;
        if ((m2 == 4) || (m2 == 6) || (m2 == 9) || (m2 == 11))   // 30 days has September, April, June and November 
          days -= 30; 
        else
          days -= 31; 
        m -= 1; 
      }
      if (d2 > d) 
      {
        days += (d2 - d);
        d2 -= (d2 - d);
      }
      if (d2 < d)
      {
        days -= (d - d2);
        d -= (d - d2);
      }
    }
    return days;
  }
}
