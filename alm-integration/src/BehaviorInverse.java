
/**
 * A Player that reacts with the sign that would lose to the sign the opponent
 * last played.
 * 
 * @author Ariana Monsalve
 *
 */
public class BehaviorInverse extends Player {

  int playSign() {
    if (theirLastMove == -1) {
      return randChoice();
    } else {
      return inverseChoice();
    }
  }
}
