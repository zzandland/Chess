package piece;

import java.util.HashMap;

public abstract class Piece {
  private static HashMap<Integer, Piece> pieceMap = new HashMap<Integer, Piece>();
  private char side;
  private char role;
  private int coord[] = new int[2];

  public Piece(char side, char role, String AN) {
    this.side = side;
    this.role = role;
    int coord[] = ANtoCoords(AN);
    this.coord[0] = coord[0];
    this.coord[1] = coord[1];
    int intCoord = generateIntCoord(coord);
    getMap().put(intCoord, this);
  }

  public static HashMap<Integer, Piece> getMap() { return pieceMap; }

  public static int generateIntCoord(int coord[]) {
    return Integer.parseInt(String.valueOf(coord[0]) + String.valueOf(coord[1]));
  }

  public static int[] ANtoCoords(String AN) {
    char chars[] = AN.toCharArray();
    int ranks = Integer.parseInt(String.valueOf(chars[1])) - 1;
    int files = Character.toLowerCase(chars[0]) - 'a';
    int coord[] = {ranks, files};
    return coord;
  }


  public char getSide() { return side; }

  public char getRole() { return role; }

  public int[] getCoord() { return coord; }

  public void setCoord(int y, int x) {
    coord[0] = y;
    coord[1] = x;
  } 

  public void kill(Piece enemy) { enemy = null; }
}

interface canMove {
  boolean move(String requestedAN);
}
