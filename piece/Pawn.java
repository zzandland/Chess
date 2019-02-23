package piece;

public class Pawn extends Piece {
  public Pawn(char side) {
    super(side, 'P');
  }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    // check vertical first; for white pawns they can only move in upward direction in AN system, whereas black pawns can only move in downard direction
    if (!(getSide() == 'W' && toCoord[0] == fromCoord[0] + 1)
      && !(getSide() == 'B' && toCoord[0] == fromCoord[0] - 1))
      return false;

    if (board[toCoord[0]][toCoord[1]] == null) {
      return toCoord[1] == fromCoord[1];
    } else {
      return toCoord[1] == fromCoord[1] - 1 || toCoord[1] == fromCoord[1] +1;
    }
  }
}
