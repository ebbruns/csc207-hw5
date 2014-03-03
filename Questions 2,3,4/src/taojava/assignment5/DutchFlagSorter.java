package taojava.assignment5;

public class DutchFlagSorter
{

  /**
   * Sorts a list of reds, whites, and blues, based on a given classifier
   * 
   * Preconditions: Input must be an array of strings, and a classifier which puts them in 3 groups.
   * Postconditions: Output will be separated into three groups, as done by the classifier.
   * @param input
   * @param classifier
   */
  
  public static void dutchFlag(String[] input, StringClassifier classifier)
  {
    int numReds = 0;
    int sortedReds = 0;
    int numWhites = 0;
    int sortedWhites = 0;
    int sortedBlues = 0;
    int currentPos = 0;
    int nextPos = 0;
    int copyPos = 0;

    boolean[] filledArray = new boolean[input.length];

    // Tells us how many of each color we have in our array
    for (int i = 0; i < input.length; i++)
      {
        if (classifier.classify(input[i]) == -1)
          {
            numReds++;
          }// if
        else if (classifier.classify(input[i]) == 0)
          {
            numWhites++;
          }// else if
      }// for

    String toSort = input[0];

    // Does the actual sorting for the problem
    for (int i = 0; i < input.length; i++)
      {
        // Sets nextPos and sortedColor based on the color
        if (classifier.classify(toSort) == -1)
          {
            nextPos = sortedReds;
            if (sortedReds < numReds - 1)
              {
                sortedReds++;
              }// if
          }// if
        else if (classifier.classify(toSort) == 0)
          {
            nextPos = numReds + sortedWhites;
            if (sortedWhites < numWhites - 1)
              {
            sortedWhites++;
              }// if
          }// else if
        else
          {
            nextPos = numReds + numWhites + sortedBlues;
            if (sortedBlues < (input.length - numReds - numWhites - 1))
              {
                sortedBlues++;
              }// if
          }// else

        // if the current value isn't already in the right place
        if (nextPos != currentPos)
          {
            String temp = input[nextPos];
            input[nextPos] = toSort;
            filledArray[nextPos] = true;
            
            //If we are putting something in a position that has an element has been accounted for
            if (nextPos == copyPos)
              {
                for (int j = 1; j < filledArray.length; j++)
                  {
                    if (!filledArray[j])
                      {
                        toSort = input[j];
                        currentPos = j;
                        copyPos = j;
                        break;
                      }// if
                  }// for
              }// if
            else
              {    
                toSort = temp;
                currentPos = nextPos;
              }//else
            
            
           
          }// if

        // if the current value is already in the right place
        else
          {
            filledArray[currentPos] = true;
            currentPos = (currentPos + 1) % input.length;
            toSort = input[currentPos];
          }// else
        
        // If we are about to try to re-sort the first element
        if (currentPos == 0)
          {
            for (int j = 1; j < filledArray.length; j++)
              {
                if (!filledArray[j])
                  {
                    currentPos = j;
                    break;
                  }// if
              }// for
          }// if

      }// for

  }// dutchFlag

  /**
   * Our main contains a couple of the string arrays we used in testing.
   * It also will print out the array after it has been sorted.
   * @param args
   */
  
  public static void main(String[] args)
  {
    RWBClassify classer = new RWBClassify();
    String[] stringArray =
        { "white", "blueeeee", "red", "blueeeeee", "red", "white", "white",
        "blueeeee", "red" , "blueeeee", "white", "white", "red", "blueeeeeeee", "blueeeee", "white", "white", "red", "blueeeeeeee"};
//     {"blueeeee", "white", "white", "red", "blueeeeeeee"};
    dutchFlag(stringArray, classer);
    for (int i = 0; i < stringArray.length; i++)
      {
        System.out.print(stringArray[i] + ", ");
      }//for
  }//main()

} // class DutchFlagSorter
