
/**
 * A player that always keeps changing their choice.
 * 
 * @author Ariana Monsalve
 *
 */
public class BehaviorChanging extends BehaviorRandom {
  // This overrides the playSign() method in BehaviorRandom. This code is used
  // instead. There is a condition at allows it to return to its parent class's
  // method.
  @Override
  int playSign() {
    if (lastResult == -2) {
      return super.playSign();
    } else {
      return changeChoice();
    }
  }
}
