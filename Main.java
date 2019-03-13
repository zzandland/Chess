import java.io.*;

public class Main {
  public static void main(String args[]) {
    try {
      Game.initGame();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
