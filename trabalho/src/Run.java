
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Alfabeto = E, G, L, O, X
 */

public class Run extends NfaParallel {

  
  NfaParallel nfaParallel = new NfaParallel();
  DfaTable dfaTable = new DfaTable();
  DfaIf dfaIf = new DfaIf();
  Nfa nfa = new Nfa();


  private void importFileAndRead () {
    File file = new File(System.getProperty("user.dir") + "/words.txt");

    if (!file.exists()) {
      System.out.println("O arquivo que voce esta tentando abrir nao existe.");
      return;
    }

    readFile(file);
  }
 
  private void readFile (File file) {
    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String w = scanner.nextLine();
        String result = nfaParallel.checkWord(w);
        System.out.println(w + ": " + result);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main (String[] args) {
    Run main = new Run();
    main.importFileAndRead();
  }

}
