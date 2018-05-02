import java.util.Scanner;

public class InputHandler {
  static int intInLoop(Scanner in) {
    boolean confirm = false;
    int get = 0;
    while (!confirm) {
      try {
        get = Integer.parseInt(in.nextLine());
        confirm = true;
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter an integer.");
      }
    }
    return get;
  }

  static double doubleInLoop(Scanner in) {
    boolean confirm = false;
    double get = 0;
    while (!confirm) {
      try {
        get = Double.valueOf(in.nextLine());
        confirm = true;
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }
    return get;
  }
}
