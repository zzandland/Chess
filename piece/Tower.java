package piece;

public class Tower extends Piece {
  public Tower(char side) { super(side, 'T'); }

  public boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    if (board[toCoord[0]][toCoord[1]] == null 
      || board[toCoord[0]][toCoord[1]].getSide() != getSide()) {
      if (fromCoord[0] == toCoord[0]) {
        int horLimit[] = getHorLimit(fromCoord, board);
        return (toCoord[1] >= horLimit[0] && toCoord[1] <= horLimit[1]);
      } else if (fromCoord[1] == toCoord[1]) {
        int verLimit[] = getVerLimit(fromCoord, board);
        return (toCoord[0] >= verLimit[0] && toCoord[0] <= verLimit[1]);
      }
    }
    return false;
  }

  private int[] getHorLimit(int fromCoord[], Piece board[][]) {
    int left = 0;
    int right = board[0].length;
    for (int i = 0; i < board[fromCoord[0]].length; i++) {
      Piece piece = board[fromCoord[0]][i];
      if (piece != null) {
        if (i < fromCoord[1] && i > left) {
          if (piece.getSide() == getSide()) left = i + 1;
          else if (piece.getSide() != getSide()) left = i;
        } else if (i > fromCoord[1] && i < right) {
          if (piece.getSide() == getSide()) right = i - 1;
          else if (piece.getSide() != getSide()) right = i;
        }
      }
    }
    int pair[] = {left, right};
    return pair;
  }

  private int[] getVerLimit(int fromCoord[], Piece board[][]) {
    int top = 0;
    int bottom = board.length;
    for (int i = 0; i < board.length; i++) {
      Piece piece = board[i][fromCoord[1]];
      if (piece != null) {
        if (i < fromCoord[0] && i > top) {
          if (piece.getSide() == getSide()) top = i + 1;
          else if (piece.getSide() != getSide()) top = i;
        } else if (i > fromCoord[0] && i < bottom) {
          if (piece.getSide() == getSide()) bottom = i - 1;
          else if (piece.getSide() != getSide()) bottom = i;
        }
      }
    }
    int pair[] = {top, bottom};
    return pair;
  }

  
}
