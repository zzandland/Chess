package piece;

public class Pawn extends Piece {
  public Pawn(char side, int[] coord) {
    super(side, 'P', coord);
  }

  public boolean moveLogic(int[] toCoord, Piece[][] board) {
    /**
     * check vertical first; for white pawns they can only move in upward direction in AN system,
     * whereas black pawns can only move in downard direction
     */
    if (!(side == 'W' && toCoord[0] == coord[0] + 1)
        && !(side == 'B' && toCoord[0] == coord[0] - 1)) return false;

    if (board[toCoord[0]][toCoord[1]] == null) {
      return toCoord[1] == coord[1];
    } else if (board[toCoord[0]][toCoord[1]].side != side) {
      return toCoord[1] == coord[1] - 1 || toCoord[1] == coord[1] + 1;
    }
    return false;
  }
}
