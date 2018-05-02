/**
 * A player that always plays a random sign.
 * 
 * @author Ariana Monsalve
 *
 */

public class BehaviorRandom extends Player {

  int playSign() {
    return randChoice();
  }

}
