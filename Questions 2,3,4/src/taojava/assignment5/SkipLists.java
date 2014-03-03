package taojava.assignment5;

/**
 * Skip lists of strings, stored alphabetically.
 */
public class SkipLists
    implements
      SetOfStrings
{
  // FIELDS
  int length;
  int maxHeight = 15;
  SkipListElt current;
  SkipListElt first;
  SkipListElt last;

  // CONSTRUCTOR
  public SkipLists()
  {
    this.first = new SkipListElt(maxHeight);
    this.last = new SkipListElt(maxHeight);
    this.current = this.first;
    // Sets every element of nextElts to "point" to last.
    for (int i = 0; i < this.first.height; i++)
      {
        this.first.nextElts[i] = last;
      }// for
  }// SkipLists

  /**
   * Tells you if the input string is contained in the SkipList
   * Preconditions: Must be called on a skipList object, contains a string.
   * Postconditions: Returns true if element is found, false otherwise.
   */
  public boolean contains(String str)
  {
    this.current = first;
    int comparison;
    for (int i = this.maxHeight - 1; i >= 0; i--)
      {
        // Makes sure we're not comparing to the last element
        if (this.current.nextElts[i].contents != null)
          {
            comparison = str.compareTo(this.current.nextElts[i].contents);
            // If we see the element we're looking for, we just stop
            if (comparison == 0)
              {
                return true;
              }// if
            // If we see we're before the element we're looking for, we move
            // forward, adding one to stay at the same level
            else if (comparison < 0)
              {
                current = current.nextElts[i];
                i++;
              }// else if
            // If we pass by it at the current level, we just go through the
            // loop again
          }// if
      }// for
    // If we break out of the loop, it means we never found equality, even at
    // level 1
    // Therefore, the element is not in the SkipList
    return false;
  }// contains

  /**
   * Adds a given string to a SkipList, position determined by alphabetical order.
   * Preconditions: Must be called on a skipList, input must be a string.
   * Postconditions: Void, but mutates the SkipList to contain a new element with given string.
   */
  public void add(String str)
  {
    this.current = first;

    // Initialize newElt
    SkipListElt newElt = new SkipListElt(str);

    // Makes previous pointers point to our new element
    for (int i = newElt.height - 1; i >= 0; i--)
      {
        // If we're not pointing to last
        if (this.current.nextElts[i].contents != null)
          {
            int comparison = str.compareTo(this.current.nextElts[i].contents);

            // If what we compare to is before our string in the alphabet, we
            // just go forward
            if (comparison < 0)
              {
                this.current = this.current.nextElts[i];
                i++;
              }// if

            // If what we compare to is after or the same as our string in the
            // alphabet
            else
              {
                newElt.nextElts[i] = this.current.nextElts[i];
                this.current.nextElts[i] = newElt;
              }// else
          }// if
        // If we are pointing to last at height i
        else
          {
            newElt.nextElts[i] = this.current.nextElts[i];
            this.current.nextElts[i] = newElt;
          }// else
      }// for
  }// add

  /**
   * Removes the given string from a SkipList
   * Preconditions: Must be called on a skip list, input must be a string
   * Postconditions: If string is found in SkipList, removes it from the list.
   * If string isn't found in the list, an exception is thrown.
   * @throws Exception 
   */
  public void remove(String str)
    throws Exception
  {
    if (this.contains(str))
      {
        this.current = first;
        for (int i = this.maxHeight - 1; i >= 0; i--)
          {
            if (this.current.nextElts[i].contents != null)
              {
                int comparison =
                    str.compareTo(this.current.nextElts[i].contents);

                if (comparison == 0)
                  {
                    this.current.nextElts[i] =
                        this.current.nextElts[i].nextElts[i];
                  }// if

                else if (comparison < 0)
                  {
                    this.current = this.current.nextElts[i];
                    i++;
                  }// else if

                // If comparison > 0 we just move down an i without changing
                // current
              }// if
          }// for
      }// if
    else
      {
        throw new Exception ("Given string not found in SkipList, cannot be removed.");
      }

  }// remove
} // class SkipListOfStrings