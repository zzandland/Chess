import piece.*;

public class Player {
  private String name;
  private char side;
  private int score = 0;
  private String kingPos;

  public Player(String name, char side) {
    this.name = name;
    this.side = side;
  }

  public String getName() {
    return name;
  }

  public String getKingPos() {
    return kingPos;
  }

  public void setKingPos(String kingPos) {
    this.kingPos = kingPos;
  }

  public char getSide() {
    return side;
  }

  public boolean movePiece(String fromAN, String toAN) {
    char result = Board.movePiece(side, fromAN, toAN);

    if (result != 'N') {
      if (result == 'K') kingPos = toAN;
      return true;
    }
    return false;
  }
}
