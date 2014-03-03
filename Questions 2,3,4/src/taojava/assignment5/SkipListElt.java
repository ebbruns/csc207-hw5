package taojava.assignment5;

/**
 * A single element of a SkipList.
 * 
 * Has a randomly generated height, and a string of contents.
 */

public class SkipListElt
{

  // FIELDS
  int height;
  int maxHeight = 15;
  String contents;
  SkipListElt[] nextElts;

  // CONSTRUCTORS

  /**
   * Makes a SkipListElement based on a contents string. Preconditions: contains
   * must be a string. Postconditions: Returns a SkipListElt of random height
   * with desired string as contents.
   * 
   * @param contains
   */
  public SkipListElt(String contains)
  {
    this.contents = contains;
    this.height = heightGen(maxHeight);
    this.nextElts = new SkipListElt[this.height];
  }// SkipListElt

  /**
   * Makes a SkipListElement based on a given height (used to make beginning and
   * end of blank SkipList) Preconditions: desiredHeight must be an integer less
   * than or equal to maxHeight of the SkipList Postconditions: Returns a
   * skipListElt of the desired height
   * 
   * @param desiredHeight
   */
  public SkipListElt(int desiredHeight)
  {
    this.height = desiredHeight;
    this.nextElts = new SkipListElt[this.height];
  }// SkipListElt

  // HELPER METHODS
  // Semi-randomly generates the height of a SkipListElt
  /**
   * Generates a random height, with each height having half the chance of being
   * produced as the one before it. Preconditions: maxHeight must be a positive
   * integer Postconditions: A integer less than or equal to maxHeight is
   * returned.
   * 
   * @param maxHeight
   * @return
   */
  public int heightGen(int maxHeight)
  {
    int rand = (int) (Math.random() * 1000000);
    for (int i = 1; i < maxHeight; i++)
      {
        if (rand >= (1000000 / (Math.pow(2, i))))
          {
            return i;
          }// if
      }// for
    return maxHeight;
  }// heightGen

}// class SkipListElt
