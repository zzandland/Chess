package piece;

public class Bishop extends Piece {
  public Bishop(char side) {
    super(side, 'B');
  }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    return diagonalDashLogic(fromCoord, toCoord, board);
  }
}
