import piece.*;

public class Player {
  private String name;
  private char side;
  private int score = 0;

  public Player(String name, char side) {
    this.name = name;
    this.side = side;
  }

  public void movePiece(String fromAN, String toAN) {
    if (!Board.movePiece(side, fromAN, toAN)) System.out.println("Invalid move. Please try again");
  }
}
