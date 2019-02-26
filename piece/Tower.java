package piece;

public class Tower extends Piece {
  public Tower(char side) { super(side, 'T'); }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    return perpedicularDashLogic(fromCoord, toCoord, board);
  }
}
