package binarySearch;

public class BinaryClass
{
  /**
   * Based on code from the eboard from Extra 2
   * http://www.cs.grinnell.edu/~rebelsky
   * /Courses/CSC207/2014S/eboards/extra.02.html
   */
  public static int binAverage(int a, int b)
  {
    int total = a / 2 + b / 2;
    if ((a % 2 == 1) && (b % 2 == 1))
      {
        total++;
      }
    return total;
  }

  /**
   * Based on code from the eboard from Class 20
   * http://www.cs.grinnell.edu/~rebelsky
   * /Courses/CSC207/2014S/eboards/eboard.20.html
   * 
   * @throws Exception
   * 
   */
  public static int binarySearch(int[] values, int val)
    throws Exception
  {
    int lb = 0;
    int ub = values.length;

    // Invariant A: for all i, 0 <= i < lb, values[i] < val
    // Invariant B: for all i, ub <= i < length, values[i] > val
    while ((ub - lb) > 0)
      {
        int mid = binAverage(lb, ub);
        if (values[mid] < val)
          lb = mid + 1;
        else if (values[mid] > val)
          ub = mid;
        else
          return mid;
      } // while ((ub - lb) > 0)
    // At this point
    // Invariant A: for all i, 0 <= i < lb, values[i] < val
    // Invariant B: for all i, ub <= i < length, values[i] > val
    // lb >= ub
    // The element is not there
    throw new Exception("Element not found");

  } // binarySearch(int[], int)
} // class BinarySearch
