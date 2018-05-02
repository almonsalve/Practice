
/**
 * A player that copies the last move of the opposing player.
 * @author Ariana Monsalve
 *
 */
public class BehaviorCopy extends Player {
  int playSign() {
    if (lastResult == -2) {
      return randChoice();
    } else {
      return theirLastMove;
    }
  }
}
