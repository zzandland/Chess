package piece;

public abstract class Piece {
  private char role;
  private int[] coord = new int[2];

  public Piece(char role, String AN) {
    this.role = role;
    int[] coord = ANtoCoords(AN);
    this.coord[0] = coord[0];
    this.coord[1] = coord[1];
  }

  public char getRole() { return role; }

  public int[] getCoord() { return coord; }

  public void setCoord(int y, int x) {
    coord[0] = y;
    coord[1] = x;
  } 

  private int[] ANtoCoords(String AN) {
  }

  public void kill(Piece enemy) { enemy = null; }
}

interface canMove {
  boolean move(int[] reqPos);
}
