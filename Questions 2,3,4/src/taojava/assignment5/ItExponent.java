package taojava.assignment5;

public class ItExponent
{

  /**
   * Exponent raises a double x to the integer n power. It does this efficiently
   * by using cool mathematical properties. Preconditions: x must be a double, n
   * must be a positive integer (0 is allowed) Postconditions: Returns x raised
   * to the nth power.
   * 
   * @param x
   * @param n
   * @return
   * @throws Exception
   */
  public static double exponent(double x, int n)
    throws Exception
  {
    int logVar = (int) Math.floor(Math.log(n) / Math.log(2));
    // Makes sure n is valid
    int exptCounter = 1;
    if (n < 0)
      {
        throw new Exception("Please enter a positive, integral exponent");
      }// if
    if (n == 0)
      {
        return 1.0;
      }// if

    double tally = x;
    for (int i = 0; i < logVar; i++)
      {
        tally *= tally;
        exptCounter *= 2;
      }// for
    for (int i = 0; i < (n - exptCounter); i++)
      {
        tally *= x;
      }// for
    return tally;

  }// exponent(double, int)

  /**
   * Our main prints out a few examples of how the program can be used. These
   * examples were generated in testing.
   * 
   * @param args
   * @throws Exception
   */

  public static void main(String[] args)
    throws Exception
  {
    System.out.println(exponent(-2, 5));
    System.out.println(exponent(50, 1));
    System.out.println(exponent(5, 2));
    System.out.println(exponent(5, 0));
    System.out.println(exponent(23, 4));
    System.out.println(exponent(0, 1000));
  }// main()

}// class ItExponent
