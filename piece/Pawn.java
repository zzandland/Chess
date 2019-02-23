package piece;

public class Pawn extends Piece {
  public Pawn(char side) {
    super(side, 'P');
  }

  public boolean moveLogic(int fromCoord[], int toCoord[]) {
    return toCoord[0] == fromCoord[0] + 1 && toCoord[1] == fromCoord[1];
  }
}
