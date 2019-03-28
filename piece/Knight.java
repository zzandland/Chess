package piece;

public class Knight extends Piece {
  public Knight(char side, int[] coord) {
    super(side, 'H', coord);
  }

  public boolean moveLogic(int[] toCoord, Piece[][] board) {
    return (((toCoord[0] + 1 == coord[0] || toCoord[0] - 1 == coord[0])
            && (toCoord[1] + 2 == coord[1] || toCoord[1] - 2 == coord[1]))
        || ((toCoord[0] + 2 == coord[0] || toCoord[0] - 2 == coord[0])
            && (toCoord[1] + 1 == coord[1] || toCoord[1] - 1 == coord[1])));
  }
}
