import java.util.Scanner;

public class HumanPlayer extends Player {
  int playSign() {
    // This should NEVER be called
    return -1;
  }

  int playSign(Scanner in) {
    while (true) {
      switch (in.nextLine().toLowerCase()) {
        case "r":
        case "rock":
          return 0;
        case "p":
        case "paper":
          return 1;
        case "s":
        case "scissors":
          return 2;
        default:
          System.out.println("Sorry, I do not understand.");
      }
    }
  }
}
