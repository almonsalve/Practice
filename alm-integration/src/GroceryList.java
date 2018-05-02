import java.util.Scanner;

/**
 * Class for making an item list that allows items to be crossed out.
 * 
 * @author Ariana Monsalve
 *
 */

public class GroceryList {
  private static String[] list;
  private static boolean listPresent = false;

  /**
   * Creates a new list. Asks for the number of items and then asks for the name
   * of each item.
   * 
   * @param sc
   *          The Scanner object that is currently reading input.
   */
  public static void createList(Scanner sc) {
    System.out.println("Declare the number of items.");
    boolean confirm = false;
    int quant = 0;
    while (!confirm) {
      try {
        quant = Integer.parseInt(sc.nextLine());
        confirm = true;
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }
    list = new String[quant];
    listPresent = true;
    int index = 0;
    for (String id : list) {
      System.out.println("Enter item " + (index + 1));
      id = sc.nextLine();
      list[index] = id;
      index++;
    }
  }

  /**
   * Prints the item list to the console.
   */
  public static void readList() {
    if (listPresent) {
      int index = 0;
      for (String id : list) {
        System.out.println((index + 1) + ": " + id);
        index++;
      }
    } else {
      System.out.println("A list has not been made yet.");
    }
  }

  /**
   * Asks for the item to be removed, and attempts to remove the item from the
   * list.
   * 
   * @param sc
   *          The Scanner object that is currently reading input.
   */
  public static void removeItem(Scanner sc) {
    if (listPresent) {
      String[] newList;
      System.out.println("Name the item to be removed");
      String removeThis = sc.nextLine();
      int index = 0;
      boolean found = false;
      for (String id : list) {
        if (id.equalsIgnoreCase(removeThis)) {
          list[index] = null;
          found = true;
          break;
        } else {
          index++;
        }
      }
      if (found == true) {
        int length = (list.length - 1);
        newList = new String[length];
        int pos1 = 0;
        int pos2 = 0;
        for (String id : list) {
          if (id != null) {
            newList[pos2] = list[pos1];
            pos1++;
            pos2++;
          } else {
            pos1++;
          }
        }
        list = java.util.Arrays.copyOfRange(newList, 0, length);
      } else {
        System.out.println(removeThis + " not found.");
      }
      readList();
    } else {
      System.out.println("A list has not been made yet.");
    }
  }
}
