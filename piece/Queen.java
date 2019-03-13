package piece;

public class Queen extends Piece {
  public Queen(char side) {
    super(side, 'Q');
  }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    return perpedicularDashLogic(fromCoord, toCoord, board)
        || diagonalDashLogic(fromCoord, toCoord, board);
  }
}
