
public class NfaParallel {

  private int currentState;

  public void reset () {
    currentState = 1 << 0; 
  }

  private int[][] delta =
      {{1 << 0, 1 << 0 | 1 << 1},   // delta[q0, E,L,O,X] = {q0},  delta[q0, G] = {q0,q1}
          {0, 1 << 2},              // delta[q1, O] = {q1},  delta[q1, G] = {q2}
          {1 << 3, 0},              // delta[q2, L] = {q3}
          {1 << 4, 0}               // delta[q3, E] = {q4}
      };

  public boolean acceptsWord (String in) {
    for (int i = 0; i < in.length(); i++) {

      if (currentState == 1 << 4) return true; 

      char c = in.charAt(i);
      int nextSS = 0; 

      for (int s = 0; s <= 3; s++) { 
        if ((currentState & (1 << s)) != 0) { 
          try {
            if (c == 'G' && (currentState == delta[0][0])) {
              nextSS |= delta[0][1];
            } else if (c == 'G' && (currentState == delta[0][1] || currentState == delta[1][1])) {
              nextSS |= delta[1][1];
            } else if (c == 'O' && (currentState == delta[0][1])) {

            } else if (c == 'L' && currentState == delta[1][1]) {
              nextSS |= delta[s][0];
            } else if (c == 'E' && currentState == delta[2][0]) {
              nextSS |= delta[s][0];

            } else if (c == 'O' && (currentState == delta[1][1])) { 
              nextSS |= delta[0][1];
              currentState = nextSS;
            } else {
              nextSS |= delta[0][0];
              reset();
            }
          } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
          }
        }
      }

      if (c != 'O')
        currentState = nextSS; 
    }

    return (currentState & (1 << 4)) != 0;
  }

  public String checkWord (String w) {
    this.reset();
    return acceptsWord(w) ? "valido" : "nao valido";
  }

}
