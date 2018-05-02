import java.util.Random;
import java.util.Scanner;

public class RpsGame {
  private int rounds;
  int p1score = 0;
  int p2score = 0;
  Player p1;
  Player p2;
  int[][] matchup = { { 0, 2, 1 }, { 1, 0, 2 }, { 2, 1, 0 } };
  int[][] results = { { 0, 1, -1 }, { 0, -1, 1 } };

  /**
   * Sets up the game, then plays it through play(in).
   * 
   * @param in
   *          The Scanner object that accepts input.
   */
  
  public RpsGame(Scanner in) {

    System.out.println("H: Human player");
    System.out.println("R: Randy Random");
    System.out.println("S: Simon Simple");
    System.out.println("I: Ingrid Contrary");
    System.out.println("D: Donny Determined");
    System.out.println("U: Urtha Unyielding");
    System.out.println("C: Cathy Copycat");
    System.out.println("E: Eclair Echoes");
    System.out.println("M: Michael Morphing");
    System.out.println("W: Wild Willy");
    System.out.println();

    System.out.println("Select player one");
    p1 = setPlayer(in);
    System.out.println("Select player two");
    p2 = setPlayer(in);
    System.out.println("Choose number of rounds");
    rounds = InputHandler.intInLoop(in);
    play(in);
  }

  private void playStepTwo(int p1s, int p2s, int rnd) {
    System.out.println("Player 1 played " + toSign(p1s));
    System.out.println("Player 2 played " + toSign(p2s));
    int result = determineResult(p1s, p2s);
    p1.findResults(tellResult(0, result), p2s);
    p2.findResults(tellResult(1, result), p1s);
    if (result == 1) {
      p1score++;
    } else if (result == 2) {
      p2score++;
    }
    System.out.println(textResult(rnd, result));
    System.out.println();
  }

  /**
   * Runs the game if there are no human players.
   */
  public void play() {
    for (int round = 0; round < rounds; round++) {
      int p1Sign = p1.playSign();
      int p2Sign = p2.playSign();
      playStepTwo(p1Sign, p2Sign, round);
    }
    printFinal();
  }

  /**
   * Starts the game after the players are set. It will switch to play() if both
   * players are controlled by the program.
   * 
   * @param in
   *          The Scanner object reading input from the players.
   */
  public void play(Scanner in) {
    if (p1 instanceof HumanPlayer || p2 instanceof HumanPlayer) {
      int p1Sign;
      int p2Sign;
      for (int round = 0; round < rounds; round++) {
        if (p1 instanceof HumanPlayer) {
          System.out.println("Player 1, please make your move.");
          p1Sign = ((HumanPlayer) p1).playSign(in);
        } else {
          p1Sign = p1.playSign();
        }
        if (p2 instanceof HumanPlayer) {
          System.out.println("Player 2, please make your move.");
          p2Sign = ((HumanPlayer) p2).playSign(in);
        } else {
          p2Sign = p2.playSign();
        }
        playStepTwo(p1Sign, p2Sign, round);
      }
      printFinal();
    } else {
      play();
    }
  }

  private void printFinal() {
    System.out.println("P1 Score: " + p1score);
    System.out.println("P2 Score: " + p2score);
    if (p1score > p2score) {
      System.out.println("Player 1 is the winner!");
    } else if (p2score > p1score) {
      System.out.println("Player 2 is the winner!");
    } else {
      System.out.println("Tied Game");
    }
    System.out.println();
  }

  /**
   * Sets one player.
   * 
   * @param in
   *          The Scanner object that accepts inut for this method.
   * @return A Player instance that corresponds to player1 or player2.
   */
  public static Player setPlayer(Scanner in) {
    Player next = null;
    while (next == null) {
      switch (in.nextLine().toLowerCase()) {
        case "h":
          next = new HumanPlayer();
          break;
        case "wild":
        case "w":
          switch (new Random().nextInt(8)) {
            case 0:
              next = new BehaviorRandom();
              break;
            case 1:
              next = new BehaviorSimple();
              break;
            case 2:
              next = new BehaviorInverse();
              break;
            case 3:
              next = new BehaviorDetermined();
              break;
            case 4:
              next = new BehaviorUnyielding();
              break;
            case 5:
              next = new BehaviorCopy();
              break;
            case 6:
              next = new BehaviorEcho();
              break;
            case 7:
              next = new BehaviorChanging();
              break;
            default:
              next = new BehaviorRandom();
          }
          break;
        case "r":
          next = new BehaviorRandom();
          break;
        case "s":
          next = new BehaviorSimple();
          break;
        case "i":
          next = new BehaviorInverse();
          break;
        case "d":
          next = new BehaviorDetermined();
          break;
        case "u":
          next = new BehaviorUnyielding();
          break;
        case "c":
          next = new BehaviorCopy();
          break;
        case "e":
          next = new BehaviorEcho();
          break;
        case "m":
          next = new BehaviorChanging();
          break;
        default:
          System.out.println("Sorry, I don't understand.");
      }
    }
    return next;
  }

  private int determineResult(int p1s, int p2s) {
    return matchup[p1s][p2s];
  }

  private int tellResult(int playerNum, int result) {
    return results[playerNum][result];
  }

  private String textResult(int round, int res) {
    switch (res) {
      case 0:
        return "Round " + (round + 1) + ": Draw";
      case 1:
        return "Round " + (round + 1) + ": P1 wins";
      case 2:
        return "Round " + (round + 1) + ": P2 wins";
      default:
        return "";
    }
  }

  private String toSign(int sign) {
    switch (sign) {
      case 0:
        return "Rock";
      case 1:
        return "Paper";
      case 2:
        return "Scissors";
      default:
        return "";
    }
  }

  // static int intInput(Scanner in) {
  // boolean confirm = false;
  // int get = 0;
  // while (!confirm) {
  // try {
  // get = Integer.valueOf(in.nextLine());
  // confirm = true;
  // } catch (Exception e) {
  // System.out.println("Invalid input. Please enter a number.");
  // }
  // }
  // return get;
  // }

}
