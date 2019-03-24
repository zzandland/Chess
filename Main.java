import java.io.*;

public class Main {
  public static void main(String args[]) {
    try {
      Game game = new Game();
      game.initGame();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
