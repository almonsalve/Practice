
/**
 * A player that copies the second to last move of the opposing player.
 * 
 * @author Ariana Monsalve
 *
 */

public class BehaviorEcho extends Player {
  int holdSign = -1;

  int playSign() {
    if (lastResult == -2) {
      return randChoice();
    } else {
      if (holdSign == -1) {
        holdSign = theirLastMove;
        return randChoice();
      } else {
        int playThisSign = holdSign;
        holdSign = theirLastMove;
        return playThisSign;
      }
    }
  }
}
