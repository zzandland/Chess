package piece;

public class Knight extends Piece {
  public Knight(char side) {
    super(side, 'H');
  }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    return (((toCoord[0] + 1 == fromCoord[0] || toCoord[0] - 1 == fromCoord[1])
            && (toCoord[1] + 2 == fromCoord[1] || toCoord[1] - 2 == fromCoord[1]))
        || ((toCoord[0] + 2 == fromCoord[0] || toCoord[0] - 2 == fromCoord[0])
            && (toCoord[1] + 1 == fromCoord[1] || toCoord[1] - 1 == fromCoord[1])));
  }
}
