package piece;

public class Tower extends Piece {
  public Tower(char side) { super(side, 'T'); }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    if (board[toCoord[0]][toCoord[1]] == null 
      || board[toCoord[0]][toCoord[1]].getSide() != getSide()) {
    }
    return perpedicularDashLogic(fromCoord, toCoord, board);
  }
}
