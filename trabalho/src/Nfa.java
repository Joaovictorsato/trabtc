import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Nfa {

  private final int q0 = 0;
  private final int q1 = 1;
  private final int q2 = 2;
  private final int q3 = 3;
  private final int q4 = 4;

  private final int[][][] delta = {
      {{0}, {0,1}},         // delta[q0, E,L,O,X], delta[q0, G]
      {{1}, {2}},           // delta[q1, O], delta[q1, G]
      {{3}},                // delta[q2, L]
      {{4}}                 // delta[q3, E]
  };

  private boolean acceptsNext(int state, String word, int pos) {

    if (pos == word.length() || state == q4) {
      return state == q4;
    }

    char c = word.charAt(pos++);

    int[] nextStates = {};
    try {

      if (c == 'G') {
        nextStates = delta[state][1];
      } else

      if (c == 'O' && state == 1) {
        nextStates = delta[state][0];
      } else

      if (c == 'L' && state == 2) {
        nextStates = delta[state][0];
      } else

      if (c == 'E' && state == 3) {
        nextStates = delta[state][0];
      } else {
        nextStates = delta[0][0];
      }

    } catch (IndexOutOfBoundsException e) {
      return false;
    }

    for (int i=0; i < nextStates.length; i++) {
      if (acceptsNext(nextStates[i], word, pos)) return true;
    }

    return false;
  }

  public String checkWord(String word) {
    return acceptsNext(q0, word, 0) ? "valido" : "nao valido";
  }

}
