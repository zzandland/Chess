package piece;

public class Bishop extends Piece {
  public Bishop(char side, int[] coord) {
    super(side, 'B', coord);
  }

  public boolean moveLogic(int[] toCoord, Piece[][] board) {
    return diagonalDashLogic(toCoord, board);
  }
}
