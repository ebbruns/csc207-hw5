package binarySearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryClassTest
{
  @Test
  public void test()
    throws Exception
  {
    for (int s = 1; s <= 32; s++)
      {
        int[] iArray = new int[s];
        for (int i = 0; i < s; i++)
          {
            iArray[i] = i * 2;
          } // for (int i = 0; i < s; i++)

        for (int i = 0; i < s; i++)
          {
            assert (BinaryClass.binarySearch(iArray, 2 * i) == i);
            try
              {
                BinaryClass.binarySearch(iArray, 2 * i + 1);
                fail("Value not found");
              } // try
            catch (Exception e)
              {
                // do nothing because we expect an exception
              } // catch (Exception e)
            try
              {
                BinaryClass.binarySearch(iArray, -1);
                fail("Value not found");
              } // try
            catch (Exception e)
              {
                // do nothing because we expect an exception;
              } // catch (Exception e)
          } // for (int i = 0; i < s; i++)
      } // for (int s = 1; s <= 32; s++)
  } // test()
} // class BinaryClassTest

// Exception tests based on response to question on StackOverflow
// http://stackoverflow.com/questions/4047472/asserting-exceptions-in-java-how
