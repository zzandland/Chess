package piece;

public abstract class Piece {
  char side;
  char role;
  int[] coord;

  public Piece(char side, char role, int[] coord) {
    this.side = side;
    this.role = role;
    this.coord = coord;
  }

  public char getSide() {
    return side;
  }

  public char getRole() {
    return role;
  }

  public void print() {
    System.out.println(coord[0] + ":" + coord[1]);
  }

  public void setCoord(int[] coord) {
    this.coord = coord;
  }

  public abstract boolean moveLogic(int toCoord[], Piece[][] board);

  protected boolean perpedicularDashLogic(int toCoord[], Piece[][] board) {
    if (coord[0] == toCoord[0]) {
      int horLimit[] = getHorLimit(board);
      return (toCoord[1] >= horLimit[0] && toCoord[1] <= horLimit[1]);
    } else if (coord[1] == toCoord[1]) {
      int verLimit[] = getVerLimit(board);
      return (toCoord[0] >= verLimit[0] && toCoord[0] <= verLimit[1]);
    }
    return false;
  }

  protected boolean diagonalDashLogic(int toCoord[], Piece[][] board) {
    return checkDiagDirection("NW", toCoord, board)
        || checkDiagDirection("NE", toCoord, board)
        || checkDiagDirection("SW", toCoord, board)
        || checkDiagDirection("SE", toCoord, board);
  }

  private int[] getHorLimit(Piece[][] board) {
    int left = 0;
    int right = board[0].length;
    for (int i = 0; i < board[coord[0]].length; i++) {
      Piece piece = board[coord[0]][i];
      if (piece != null) {
        if (i < coord[1] && i > left) {
          if (piece.side == side) left = i + 1;
          else if (piece.side != side) left = i;
        } else if (i > coord[1] && i < right) {
          if (piece.side == side) right = i - 1;
          else if (piece.side != side) right = i;
        }
      }
    }
    int pair[] = {left, right};
    return pair;
  }

  private int[] getVerLimit(Piece[][] board) {
    int top = 0;
    int bottom = board.length;
    for (int i = 0; i < board.length; i++) {
      Piece piece = board[i][coord[1]];
      if (piece != null) {
        if (i < coord[0] && i > top) {
          if (piece.side == side) top = i + 1;
          else if (piece.side != side) top = i;
        } else if (i > coord[0] && i < bottom) {
          if (piece.side == side) bottom = i - 1;
          else if (piece.side != side) bottom = i;
        }
      }
    }
    int pair[] = {top, bottom};
    return pair;
  }

  private boolean checkDiagDirection(String direction, int toCoord[], Piece[][] board) {
    int i = 1;
    int yOffset, xOffset;
    boolean loopContinue;

    while (true) {
      switch (direction) {
        case "NW":
          yOffset = coord[0] - i;
          xOffset = coord[1] - i;
          loopContinue = yOffset >= 0 && xOffset >= 0;
          break;
        case "NE":
          yOffset = coord[0] - i;
          xOffset = coord[1] + i;
          loopContinue = yOffset >= 0 && xOffset < board.length;
          break;
        case "SW":
          yOffset = coord[0] + i;
          xOffset = coord[1] - i;
          loopContinue = yOffset < board.length && xOffset >= 0;
          break;
        case "SE":
          yOffset = coord[0] + i;
          xOffset = coord[1] + i;
          loopContinue = yOffset < board.length && xOffset < board.length;
          break;
        default:
          yOffset = coord[0];
          xOffset = coord[1];
          loopContinue = false;
      }

      if (!loopContinue) break;

      if (yOffset == toCoord[0] && xOffset == toCoord[1]) {
        if (board[yOffset][xOffset] == null || board[yOffset][xOffset].side != side) {
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
