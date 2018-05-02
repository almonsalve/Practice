import java.util.Scanner;

public class StringManipulationDemo {
  /*
   * This uses static fields and methods so that a new object does not need to
   * be created. A static method or field belongs to the class, and static
   * methods can be called without an instance of the class because it does not
   * need instance fields.
   */
  private static StringBuilder build = new StringBuilder();
  private static String errorInput = "Sorry I do not understand.";

  /**
   * The base method that provides a menu for the other methods. This method can
   * call the other methods.
   * 
   * @param sc
   *          The Scanner object reading input for the menus.
   */
  public static void menu(Scanner sc) {
    System.out.println(
        "This method demonstrates the ability of the StringBuilder class.");
    System.out.println("Please enter a number from 1-6.");
    System.out.println("Enter \"x\" to exit.");
    boolean running = true;
    while (running) {
      System.out.println("1: Create or replace String in StringBuilder");
      System.out.println("2: View the string as it is in StringBuilder");
      System.out.println("3: Append something to the end of the String");
      System.out.println("4: Insert something somewhere in the String");
      System.out.println("5: Delete some characters");
      System.out.println("6: Reverse the String");
      String input = sc.nextLine();
      try {
        int option = Integer.parseInt(input);
        switch (option) {
          case 1:
            System.out.println("Type what you want inside the StringBuilder.");
            build = new StringBuilder(sc.nextLine());
            break;
          case 2:
            System.out.println(printString());
            break;
          case 3:
            System.out.println("Type what you want to add.");
            build.append(sc.nextLine());
            System.out.println("The String is now:");
            System.out.println(printString());
            break;
          case 4:
            System.out.println("Type what you want to insert");
            String insertText = sc.nextLine();
            System.out.println("Type the offset of the insertion");
            try {
              build.insert(Integer.parseInt(sc.nextLine()), insertText);
            } catch (Exception ex) {
              System.out
                  .println("Offset invalid. Appending text to end of String.");
            }
            System.out.println("The String is now:");
            System.out.println(printString());
            break;
          case 5:
            System.out
                .println("Type the index of the first character to delete.");
            int start = InputHandler.intInLoop(sc);
            System.out.println("Type the number of characters to delete.");
            int end = InputHandler.intInLoop(sc) + start;
            try {
              build.delete(start, end);
              System.out.println("The String is now:");
              System.out.println(printString());
            } catch (Exception ex) {
              if (start < 0) {
                System.out
                    .println("Invalid input. Starting index is negative.");
              } else if (start >= build.length()) {
                System.out
                    .println("Invalid input. Starting index is greater than"
                        + " length of String.");
              } else if (start > end) {
                System.out.println(
                    "Invalid input. Cannot delete a negative number of "
                        + "characters.");
              } else {
                System.out.println("Error. I don't know what happened "
                    + "to get this message.");
              }

            }
            break;
          case 6:
            build.reverse();
            System.out.println("The String is now: ");
            System.out.println(printString());
            break;
          default:
            System.out
                .println(errorInput + "\nPlease enter a number from 1-6.");
            System.out.println("Type \"x\" to exit.");
        }
      } catch (NumberFormatException ex) {
        if (input.equalsIgnoreCase("x")) {
          running = false;
        } else {
          System.out.println(errorInput + " Please enter a number from 1-6.");
          System.out.println("Type \"x\" to exit.");
        }
      }
    }
  }

  private static String printString() {
    return build.toString();
  }
}
