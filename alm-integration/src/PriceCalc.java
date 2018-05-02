
// PSI 1:
import java.util.Scanner;

public class PriceCalc {
  /**
   * A method for adding up prices and calculating total price with tax.
   * 
   * @param scan
   *          The Scanner object that reads input for this method.
   */
  public static void calculatePrice(Scanner scan) {
    boolean on = true;
    double finalTotal;
    double totalNoTax = 0.0;
    double itemPrice = 0.0;
    int itemQuant = 0;
    while (on) {
      boolean res1Confirm = false;
      while (!res1Confirm) {
        System.out.println("Enter price of item");
        String res1 = scan.nextLine();
        try {
          itemPrice = Double.valueOf(res1);
          res1Confirm = true;
        } catch (Exception e) {
          System.out.println("Invalid input. Please enter a number.");
        }
      }

      boolean res2Confirm = false;
      System.out.println("Enter quantity of item");
      while (!res2Confirm) {
        String res2 = scan.nextLine();
        try {
          itemQuant = Integer.parseInt(res2);
          res2Confirm = true;
        } catch (Exception e) {
          System.out.println("Invalid input. Please enter an integer.");
        }
      }
      totalNoTax += (itemPrice * itemQuant);
      System.out.println("Would you like to add another item?");
      boolean loopConfirm = false;
      while (!loopConfirm) {
        String ans = scan.nextLine();
        if (ans.equalsIgnoreCase("N") || ans.equalsIgnoreCase("No")) {
          on = false;
          loopConfirm = true;
        } else if (ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("Yes")) {
          loopConfirm = true;
        } else {
          System.out.println("Sorry, I do not understand.");
        }
      }
    }
    System.out.println("Enter tax rate in percent");
    boolean res3Confirm = false;
    while (!res3Confirm) {
      String res3 = scan.nextLine();
      // removes percentage sign if user literally enters percent
      res3 = res3.replaceAll("%", "");
      try {
        finalTotal = totalNoTax * ((0.01 * (Double.valueOf(res3))) + 1);
        System.out.println("The total price is $" + finalTotal + ".");
        on = false;
        res3Confirm = true;
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }
  }
}
