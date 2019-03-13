package piece;

public class King extends Piece {
  public King(char side) {
    super(side, 'K');
  }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    return (board[toCoord[0]][toCoord[1]] == null
            || board[toCoord[0]][toCoord[1]].getSide() != getSide())
        && (fromCoord[0] == toCoord[0]
            || fromCoord[0] == toCoord[0] + 1
            || fromCoord[0] == toCoord[0] - 1)
        && (fromCoord[1] == toCoord[1]
            || fromCoord[1] == toCoord[1] + 1
            || fromCoord[1] == toCoord[1] - 1);
  }
}
