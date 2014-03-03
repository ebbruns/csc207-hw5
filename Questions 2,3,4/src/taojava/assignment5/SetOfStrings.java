package taojava.assignment5;

/**
 * Simple sets of strings.
 */
public interface SetOfStrings
{
  /**
   * Determine if the set contains a particular string.
   */
  public boolean contains(String str);

  /**
   * Add an element to the set.
   * 
   * @post contains(str)
   */
  public void add(String str);

  /**
   * Remove an element from the set.
   * 
   * @throws Exception
   */
  public void remove(String str)
    throws Exception;
} // interface SetOfStrings