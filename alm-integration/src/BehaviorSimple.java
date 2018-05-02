
public class BehaviorSimple extends Player {

  int playSign() {
    if (theirLastMove == -1) {
      return randChoice();
    } else {
      return counterChoice();
    }
  }

}
