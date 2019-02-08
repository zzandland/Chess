package piece;

public class Pawn extends Piece implements canMove {
  public Pawn(int y, int x) {
    super('P', y, x);
  }

  public boolean move(int[] reqPos) {
    if (moveLogic(reqPos)) {
      setCoord(reqPos[0], reqPos[1]);
      return true;
    } else {
      System.out.println("Cannot move to ");
      return false;
    }
  }

  private boolean moveLogic(int[] reqPos) {
    int orgPos[] = getCoord();
    if (reqPos[0] == orgPos[0] + 1 && reqPos[0] == orgPos[0]) return true;
    else return false;
  }
}
