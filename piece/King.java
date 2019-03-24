package piece;

public class King extends Piece {
  public King(char side, int[] coord) {
    super(side, 'K', coord);
  }

  public boolean moveLogic(int[] toCoord, Piece[][] board) {
    return (board[toCoord[0]][toCoord[1]] == null
            || board[toCoord[0]][toCoord[1]].side != side)
        && (coord[0] == toCoord[0]
            || coord[0] == toCoord[0] + 1
            || coord[0] == toCoord[0] - 1)
        && (coord[1] == toCoord[1]
            || coord[1] == toCoord[1] + 1
            || coord[1] == toCoord[1] - 1);
  }

  // TODO: need to work on checkmate functionality
  // public boolean checkmatePos() {
    // if (board[coord[0]][coord[1]] != null) return false; 
    // return true;
  // }
}
