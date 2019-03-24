package piece;

public class Queen extends Piece {
  public Queen(char side, int[] coord) {
    super(side, 'Q', coord);
  }

  public boolean moveLogic(int[] toCoord, Piece[][] board) {
    return perpedicularDashLogic(toCoord, board) || diagonalDashLogic(toCoord, board);
  }
}
