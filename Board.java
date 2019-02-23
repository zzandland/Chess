import piece.*;

public class Board {
  private static Piece board[][] = new Piece[8][8];

  public static void printBoard() { 
    for (Piece row[] : board) {
      System.out.println("||==|==|==|==|==|==|==|==||");
      System.out.print("||");
      for (Piece piece : row) {
        if (piece != null) {
          String name = "" + piece.getSide() + piece.getRole();
          System.out.print(name);
        } else {
          System.out.print("  ");
        }
        System.out.print('|');
      }
      System.out.println('|');
    }
    System.out.println("||==|==|==|==|==|==|==|==||\n");
  }

  public static void placePiece(char side, char role, String AN) {
    int coord[] = ANtoCoords(AN); 

    switch (role) {
      case 'P':
        Pawn piece = new Pawn(side);
        board[coord[0]][coord[1]] = piece;
        break;
    }
  }

  public static boolean movePiece(char side, String fromAN, String toAN) {
    int fromCoord[] = ANtoCoords(fromAN);
    int toCoord[] = ANtoCoords(toAN);
    Piece target = board[fromCoord[0]][fromCoord[1]];

    if (target == null) return false;

    if (isValidPlayer(side, target) && isValidMove(fromCoord, toCoord, target)) {
      board[fromCoord[0]][fromCoord[1]] = null;
      board[toCoord[0]][toCoord[1]] = target;
      return true;
    } 
    return false;
  }

  private static boolean isValidMove(int fromCoord[], int toCoord[], Piece target) {
    return target.moveLogic(fromCoord, toCoord);
  }

  private static boolean isValidPlayer(char side, Piece target) {
    return target.getSide() == side;
  }

  private static int[] ANtoCoords(String AN) {
    char chars[] = AN.toCharArray();
    int ranks = Integer.parseInt(String.valueOf(chars[1])) - 1;
    int files = Character.toLowerCase(chars[0]) - 'a';
    int coord[] = {ranks, files};
    return coord;
  }

}
