
// PSI 1: Utilizes -

import java.util.Random;
import java.util.Scanner;

/**
 * A silly class for a text-based adventure with a beverage.
 * 
 * @author Ariana Monsalve
 *
 */
public class Beverage {

  /**
   * A text-based adventure for drinking a hot cup of coffee.
   * 
   * @param sc
   *          The Scanner object that reads input for this method.
   */
  public static void coffeeSim(Scanner sc) {
    int desc = 0;
    System.out.println("A hot cup of coffee rests in front of you.");
    System.out.println("You can");
    System.out.println("* take a tiny sip");
    System.out.println("* drink it modestly or");
    System.out.println("* chug it");
    Random ran = new Random();
    int coffeeVolume = 100;
    while (coffeeVolume > 0) {
      System.out.println("What will you do?");
      String input = sc.nextLine();
      input = input.toLowerCase();
      if (input.contains("sip")) {
        System.out.println("You take a sip.");
        coffeeVolume -= (ran.nextInt(5) + 1);
      } else if (input.contains("drink")) {
        System.out.println("You drink the coffee.");
        coffeeVolume -= (ran.nextInt(6) + 10);
      } else if (input.contains("chug")) {
        System.out.println("You chug the coffee.");
        coffeeVolume -= (ran.nextInt(11) + 20);
      } else {
        System.out.println("Nothing happened.");
      }

      if (coffeeVolume <= 0) {
        System.out.println("The cup is empty.");
      } else if (coffeeVolume <= 15 && desc < 3) {
        System.out.println("You feel there's barely any coffee left.");
        desc = 3;
      } else if (coffeeVolume <= 40 && desc < 2) {
        System.out.println("You start wishing you drank the coffee slower.");
        desc = 2;
      } else if (coffeeVolume <= 70 && desc < 1) {
        System.out.println("You feel the cup getting lighter.");
        desc = 1;
      }
    }
  }
}
