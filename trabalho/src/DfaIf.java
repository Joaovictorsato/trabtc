
public class DfaIf {

  private int currState;

  public String checkWord (String word) {
    currState = 0;
    for (int i = 0; i < word.length(); i++) {
      checkWordsIf(word.charAt(i));
    }

    return (currState == 4) ? "valido" : "nao valido";
  }

  private void checkWordsIf (char next) {
    if (currState == 0) {
      if (next == 'G') {
        increaseState();
      }
    } else if (currState == 1) {
      if (next == 'G') {
        increaseState();
      } else if (next != 'O') {
        returnToStart();
      }
    } else if (currState == 2) {
      if (next == 'O') {
        decreaseState();
      } else if (next == 'E' || next == 'X') {
        returnToStart();
      } else if (next == 'L') {
        increaseState();
      }
    } else if (currState == 3) {
      if (next == 'E') {
        increaseState();
      } else {
        returnToStart();
      }
    }
  }

  private void checkWordsSwitch(char next) {
    //exemplo em switch case
    switch (currState) {
      case 0:
        switch (next) {
          case 'G':
            increaseState();
            break;
        }
        break;
      case 1:
        switch (next) {
          case 'G':
            increaseState();
            break;
          case 'O':
            break;
          default:
            returnToStart();
            break;
        }
        break;
      case 2:
        switch (next) {
          case 'G':
            break;
          case 'O':
            decreaseState();
            break;
          case 'L':
            increaseState();
            break;
          default:
            returnToStart();
            break;
        }
        break;
      case 3:
        switch (next) {
          case 'E':
            increaseState();
            break;
          default:
            returnToStart();
            break;
        }
        break;
      default:
    }
  }


  /**
   * Modificadores de Estado
   */
  private void increaseState () {
    currState++;
  }

  private void decreaseState () {
    currState--;
  }

  private void returnToStart () {
    currState = 0;
  }


}
