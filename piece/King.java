public class King extends Piece implements canMove {
  public King(int y, int x) {
    super('K', y, x);
  }

  public boolean move(int[] reqPos) {
    int orgPos[] = getCoord();
    if (reqPos[0] == orgPos[0] + 1 && reqPos[0] == orgPos[0]) {
      setCoord(reqPos[0], reqPos[1]);
      return true;
    } else {
      return false;
    }
  }
}
