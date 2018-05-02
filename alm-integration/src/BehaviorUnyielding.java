
public class BehaviorUnyielding extends Player {

  boolean streak = false;

  int playSign() {
    if (lastResult == -2) {
      return randChoice();
    } else if (lastResult == 1) {
      streak = false;
      return myLastMove;
    } else {
      if (!streak) {
        streak = true;
        return myLastMove;
      } else {
        return changeChoice();
      }
    }
  }
}
