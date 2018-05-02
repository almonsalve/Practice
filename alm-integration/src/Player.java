import java.util.Random;

/**
 * Framework for an RPS Player. Cannot be created as an object.
 * @author Ariana Monsalve
 *
 */
public abstract class Player {
  // This class is the parent of a bunch of other classes
  // This class demonstrates inheritance by having its subclasses inherit the
  // abstract method playSign(), which is given unique code for each subclass.
  //
  // ABSTRACT- cannot be created as an object
  protected int lastResult = -2;
  protected int myLastMove = -1;
  protected int theirLastMove = -1;

  void findResults(int winLoss, int enemyMove) {
    lastResult = winLoss;
    theirLastMove = enemyMove;
  }

  abstract int playSign();

  // Key 0:Rock 1:Paper 2:Scissors

  protected int randChoice() {
    int choice = new Random().nextInt(3);
    myLastMove = choice;
    return choice;
  }

  protected int counterChoice() {
    switch (theirLastMove) {
      case 0:
        myLastMove = 1;
        return 1;
      case 1:
        myLastMove = 2;
        return 2;
      case 2:
        myLastMove = 0;
        return 0;
      default:
        return -1;
    }
  }

  protected int inverseChoice() {
    switch (theirLastMove) {
      case 0:
        myLastMove = 2;
        return 2;
      case 1:
        myLastMove = 0;
        return 0;
      case 2:
        myLastMove = 1;
        return 1;
      default:
        return -1;
    }
  }

  protected int changeChoice() {
    int choice = myLastMove;
    while (choice == myLastMove) {
      choice = new Random().nextInt(3);
    }
    myLastMove = choice;
    return choice;
  }

}
