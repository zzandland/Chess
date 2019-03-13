package piece;

public class Rook extends Piece {
  public Rook(char side) {
    super(side, 'R');
  }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    return perpedicularDashLogic(fromCoord, toCoord, board);
  }
}
