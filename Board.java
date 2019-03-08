import piece.*;

public class Board {
  private static Piece board[][] = new Piece[8][8];

  public static void printBoard() { 
    System.out.println("       A      B      C      D      E      F      G      H");
    System.out.println("\n  ||======|======|======|======|======|======|======|======||\n");
    for (int i = board.length - 1; i >= 0; i--) {
      System.out.print(i + 1 + " ||");
      for (Piece piece : board[i]) {
        if (piece != null) {
          System.out.print(String.format("  %c   ", getSymbol(piece)));
        } else {
          System.out.print("      ");
        }
        System.out.print('|');
      }
      System.out.println('|');
      System.out.println("\n  ||======|======|======|======|======|======|======|======||\n");
    }
    System.out.println("\n\n");
  }

  public static void initBoard() {
    board = new Piece[8][8];
    initPawn();
    placePiece('W', 'K', "D1");
    placePiece('B', 'K', "D8");
    placePiece('W', 'Q', "E1");
    placePiece('B', 'Q', "E8");
    placePiece('W', 'R', "A1");
    placePiece('W', 'R', "H1");
    placePiece('B', 'R', "A8");
    placePiece('B', 'R', "H8");
    placePiece('W', 'B', "C1");
    placePiece('W', 'B', "F1");
    placePiece('B', 'B', "C8");
    placePiece('B', 'B', "F8");
    placePiece('W', 'H', "B1");
    placePiece('W', 'H', "G1");
    placePiece('B', 'H', "B8");
    placePiece('B', 'H', "G8");
  }

  public static void initPawn() {
    for (int i = 65; i < 73; i++) {
      char ranks = (char) i;
      placePiece('W', 'P', ranks + "2");
      placePiece('B', 'P', ranks + "7");
    }
  }

  public static void placePiece(char side, char role, String AN) {
    int coord[] = ANtoCoords(AN); 

    switch (role) {
      case 'K':
        King king = new King(side);
        board[coord[0]][coord[1]] = king;
        break;
      case 'Q':
        Queen queen = new Queen(side);
        board[coord[0]][coord[1]] = queen;
        break;
      case 'R':
        Rook rook = new Rook(side);
        board[coord[0]][coord[1]] = rook;
        break;
      case 'B':
        Bishop bishop = new Bishop(side);
        board[coord[0]][coord[1]] = bishop;
        break;
      case 'H':
        Knight knight = new Knight(side);
        board[coord[0]][coord[1]] = knight;
        break;
      case 'P':
        Pawn pawn = new Pawn(side);
        board[coord[0]][coord[1]] = pawn;
        break;
    }
  }

  public static char movePiece(char side, String fromAN, String toAN) {
    int fromCoord[] = ANtoCoords(fromAN);
    int toCoord[] = ANtoCoords(toAN);
    Piece target = board[fromCoord[0]][fromCoord[1]];

    // the selected AN cannot be empty nor same to desired AN
    if (target == null || fromAN.equals(toAN)) return 'N';

    // if the toCoord is out of index boundary invalid move
    if (toCoord[0] > 7 || toCoord[0] < 0 || toCoord[1] > 7 || toCoord[1] < 0) return 'N';

    if (isValidPlayer(side, target) && isValidMove(fromCoord, toCoord, target)) {
      board[fromCoord[0]][fromCoord[1]] = null;
      board[toCoord[0]][toCoord[1]] = target;
      if (target.getRole() == 'K') return 'K';
      return 'Y';
    } 
    return 'N';
  }

  public static boolean isCheck(String movedAN, String kingAN) {
    int movedCoord[] = ANtoCoords(movedAN);
    int kingCoord[] = ANtoCoords(kingAN);

    Piece piece =  board[movedCoord[0]][movedCoord[1]];
    return isValidMove(movedCoord, kingCoord, piece);
  }

  public static boolean isCheckMated(String kingAN) {
    int kingCoord[] = ANtoCoords(kingAN);
    Piece king = board[kingCoord[0]][kingCoord[1]];
    return true;
  }

  private static char getSymbol(Piece piece) {
    char symbol = ' ';
    if (piece.getSide() == 'W') {
      switch (piece.getRole()) {
        case 'K': symbol = '♔'; break;
        case 'Q': symbol = '♕'; break;
        case 'R': symbol = '♖'; break;
        case 'B': symbol = '♗'; break;
        case 'H': symbol = '♘'; break;
        case 'P': symbol = '♙'; break;
      }
    } else {
      switch (piece.getRole()) {
        case 'K': symbol = '♚'; break;
        case 'Q': symbol = '♛'; break;
        case 'R': symbol = '♜'; break;
        case 'B': symbol = '♝'; break;
        case 'H': symbol = '♞'; break;
        case 'P': symbol = '♟'; break;
      }          
    }
    return symbol;
  }

  private static boolean isValidMove(int fromCoord[], int toCoord[], Piece target) {
    if (target.moveLogic(fromCoord, toCoord, board)) {
      return true;
    } 
    System.out.println("Invalid move. Please try again.\n");
    return false;
  }

  private static boolean isValidPlayer(char side, Piece target) {
    if (target.getSide() == side) return true;
    System.out.println("That is not your piece. Please try again.\n");
    return false;
  }

  private static int[] ANtoCoords(String AN) {
    char chars[] = AN.toCharArray();
    int ranks = Integer.parseInt(String.valueOf(chars[1])) - 1;
    int files = Character.toLowerCase(chars[0]) - 'a';
    int coord[] = {ranks, files};
    return coord;
  }
}
