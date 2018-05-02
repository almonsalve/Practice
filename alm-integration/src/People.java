import java.util.Scanner;

public class People {
  private double[] heights;

  /**
   * Makes an array of heights, and spouts out some statistics about the list.
   * 
   * @param scan
   *          The Scanner object reading input.
   */
  public People(Scanner scan) {
    System.out.println(
        "This method returns the tallest and shortest of a group of people.");
    System.out.println("How many people are you entering data for?");
    boolean confirm = false;
    int size = 0;
    while (!confirm) {
      try {
        size = InputHandler.intInLoop(scan);
        if (size <= 0) {
          throw new Exception();
        }
        heights = new double[size];
        confirm = true;
      } catch (Exception ex) {
        System.out
            .println("Invalid input. Enter an integer greater than zero.");
      }
    }
    for (int ind = 0; ind < size; ind++) {
      System.out.println("Enter the height of Person " + (ind + 1));
      boolean confirmed = false;
      while (!confirmed) {
        double in = InputHandler.doubleInLoop(scan);
        if (in < 0) {
          System.out.println("Height cannot be negative. Try again.");
        } else {
          heights[ind] = in;
          confirmed = true;
        }
      }
    }
    double sum = 0;
    for (int ind = 0; ind < size; ind++) {
      sum += heights[ind];
    }
    System.out.println("The sum of all heights is " + sum);
    double shortest = 0.0;
    int smallest = 0;
    for (int ind = 0; ind < size; ind++) {
      if (ind == 0) {
        shortest = heights[ind];
      } else if (shortest > heights[ind]) {
        shortest = heights[ind];
        smallest = ind;
      }
    }
    System.out.println(
        "The shortest person is Person " + (smallest + 1) + " at " + shortest);
    double tallest = 0.0;
    int biggest = 0;
    for (int ind = 0; ind < size; ind++) {
      if (ind == 0) {
        tallest = heights[ind];
      } else if (tallest < heights[ind]) {
        tallest = heights[ind];
        biggest = ind;
      }
    }
    System.out.println(
        "The tallest person is Person " + (biggest + 1) + " at " + tallest);
  }
}
