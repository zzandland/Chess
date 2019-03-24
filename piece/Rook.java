package piece;

public class Rook extends Piece {
  public Rook(char side, int[] coord) {
    super(side, 'R', coord);
  }

  public boolean moveLogic(int[] toCoord, Piece[][] board) {
    return perpedicularDashLogic(toCoord, board);
  }
}
