package piece;

public class Pawn extends Piece implements canMove {
  public Pawn(char side, String AN) {
    super(side, 'P', AN);
  }

  public boolean move(String requestedAN) {
    int requestedCoord[] = ANtoCoords(requestedAN);

    if (moveLogic(requestedCoord)) {
      Piece.getMap().remove(generateIntCoord(getCoord()));
      setCoord(requestedCoord[0], requestedCoord[1]);
      Piece.getMap().put(generateIntCoord(requestedCoord), this);
      return true;
    }
    return false;
  }

  private boolean moveLogic(int requestedCoord[]) {
    int originalCoord[] = getCoord();

    return requestedCoord[0] == originalCoord[0] + 1 && requestedCoord[1] == originalCoord[1];
  }

  private boolean attackLogic(int requestedCoord[], String board[][]) {
    return true;
  }
}
