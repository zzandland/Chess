package piece;

public abstract class Piece {
  private char side;
  private char role;

  public Piece(char side, char role) {
    this.side = side;
    this.role = role;
  }

  public char getSide() {
    return side;
  }

  public char getRole() {
    return role;
  }

  public abstract boolean moveLogic(int fromCoord[], int toCoord[], Piece board[][]);

  protected boolean perpedicularDashLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    if (fromCoord[0] == toCoord[0]) {
      int horLimit[] = getHorLimit(fromCoord, board);
      return (toCoord[1] >= horLimit[0] && toCoord[1] <= horLimit[1]);
    } else if (fromCoord[1] == toCoord[1]) {
      int verLimit[] = getVerLimit(fromCoord, board);
      return (toCoord[0] >= verLimit[0] && toCoord[0] <= verLimit[1]);
    }
    return false;
  }

  protected boolean diagonalDashLogic(int fromCoord[], int toCoord[], Piece board[][]) {
    return checkDiagDirection("NW", fromCoord, toCoord, board)
        || checkDiagDirection("NE", fromCoord, toCoord, board)
        || checkDiagDirection("SW", fromCoord, toCoord, board)
        || checkDiagDirection("SE", fromCoord, toCoord, board);
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

  private boolean checkDiagDirection(
      String direction, int fromCoord[], int toCoord[], Piece board[][]) {
    int i = 1;
    int yOffset, xOffset;
    boolean loopContinue;

    while (true) {
      switch (direction) {
        case "NW":
          yOffset = fromCoord[0] - i;
          xOffset = fromCoord[1] - i;
          loopContinue = yOffset >= 0 && xOffset >= 0;
          break;
        case "NE":
          yOffset = fromCoord[0] - i;
          xOffset = fromCoord[1] + i;
          loopContinue = yOffset >= 0 && xOffset < board.length;
          break;
        case "SW":
          yOffset = fromCoord[0] + i;
          xOffset = fromCoord[1] - i;
          loopContinue = yOffset < board.length && xOffset >= 0;
          break;
        case "SE":
          yOffset = fromCoord[0] + i;
          xOffset = fromCoord[1] + i;
          loopContinue = yOffset < board.length && xOffset < board.length;
          break;
        default:
          yOffset = fromCoord[0];
          xOffset = fromCoord[1];
          loopContinue = false;
      }

      if (!loopContinue) break;

      if (yOffset == toCoord[0] && xOffset == toCoord[1]) {
        if (board[yOffset][xOffset] == null || board[yOffset][xOffset].getSide() != getSide()) {
          return true;
        }
        return false;
      }

      if (board[yOffset][xOffset] != null) {
        return false;
      }

      i++;
    }
    return false;
  }
}
