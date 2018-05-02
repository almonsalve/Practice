import java.util.Random;
import java.util.Scanner;

public class RandGen {
  /**
   * Generates one random hex code for a color.
   */
  public static void randColor() {
    String colorValue = "#";
    for (int num = 0; num < 6; num++) {
      Random rand = new Random();
      int in = rand.nextInt(16);
      switch (in) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
          colorValue += in;
          break;
        case 10:
          colorValue += "A";
          break;
        case 11:
          colorValue += "B";
          break;
        case 12:
          colorValue += "C";
          break;
        case 13:
          colorValue += "D";
          break;
        case 14:
          colorValue += "E";
          break;
        case 15:
          colorValue += "F";
          break;
        default:
          colorValue = "";
      }
    }
    System.out.println(colorValue);
  }

  /**
   * Asks for a number of colors to be generated, then prints out that many hex
   * color codes.
   * 
   * @param sc
   *          The Scanner Objects accepting input.
   */
  public static void color(Scanner sc) {
    System.out.println("How many colors do you want generated?");
    int count = 0;
    try {
      count = Integer.parseInt(sc.nextLine());
    } catch (Exception e) {
      System.out.println("Invalid input.");
    }
    for (int num = 0; num < count; num++) {
      randColor();
    }
  }
}
