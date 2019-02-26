import piece.*;

public class Player {
  private String name;
  private char side;
  private int score = 0;

  public Player(String name, char side) {
    this.name = name;
    this.side = side;
  }

  public String getName() { return name; }

  public boolean movePiece(String fromAN, String toAN) {
    return Board.movePiece(side, fromAN, toAN);
  }
}
