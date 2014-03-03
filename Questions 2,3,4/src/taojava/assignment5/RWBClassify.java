package taojava.assignment5;

public class RWBClassify
    implements
      StringClassifier
{
  boolean isClassifier;

  public RWBClassify()
  {
    this.isClassifier = true;
  }// RWBClassify()

  /*
   * (non-Javadoc)
   * 
   * @see taojava.assignment5.StringClassifier#classify(java.lang.String) In
   * this implementation of the interface, "red" has length < 5 "white" has
   * length == 5 and "blue" has length > 5
   */
  public int classify(String input)
  {
    int length = input.length();
    if (length < 5)
      {
        return -1;
      }// if
    else if (length == 5)
      {
        return 0;
      }// else if
    else
      {
        return 1;
      }// else
  }// classify(String)

}// class RWBClassify; implements StringClassifier
