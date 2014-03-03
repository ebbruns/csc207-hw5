package taojava.assignment5;

public class SkipListExpts
{

  /**
   * Some experiments we wrote to show that our SkipLists work well.
   * 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception
  {
    SkipLists list1 = new SkipLists();
    list1.add("HelloWorld");
    list1.add("hi");
    list1.add("hi");
    list1.add("You're a jerk");
    list1.add("Pls no breakarino");
    list1.remove("Pls no breakarino");
    list1.remove("hi");
    System.out.println(list1.contains("HelloWorld"));
    System.out.println(list1.contains("gravy"));
    System.out.println(list1.contains("Pls no breakarino"));
    System.out.println(list1.contains("hi"));
    
    list1.remove("hi");
    System.out.println("After second removal " + list1.contains("hi"));
    
    //System.out.println(list1)

  }// main()

}// class SkipListExpts
