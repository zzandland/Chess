package piece;

public class Pawn extends Piece {
  public Pawn(char side) {
    super(side, 'P');
  }

  public boolean moveLogic(int orgCoord[], int reqCoord[]) {
    return reqCoord[0] == orgCoord[0] + 1 && reqCoord[1] == orgCoord[1];
  }

  private boolean attackLogic(int requestedCoord[], String board[][]) {
    return true;
  }
}
