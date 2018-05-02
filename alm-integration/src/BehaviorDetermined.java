
/**
 * A player that repeats its last move until it loses a match.
 * @author Ariana Monsalve
 *
 */
public class BehaviorDetermined extends Player {

  int playSign() {
    if (lastResult == -2) {
      return randChoice();
    } else if (lastResult >= 0) {
      return myLastMove;
    } else {
      return changeChoice();
    }
  }
}
