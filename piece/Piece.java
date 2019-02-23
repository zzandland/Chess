package piece;

public abstract class Piece {
  private char side;
  private char role;

  public Piece(char side, char role) {
    this.side = side;
    this.role = role;
  }

  public char getSide() { return side; }

  public char getRole() { return role; }

  abstract boolean moveLogic(int orgCoord[], int reqCoord[]);
}
