import piece.*;

public class Board {
  private Piece board[][] = new Piece[8][8];

  public void printBoard() {
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

  public void initBoard(Player player1, Player player2) {
    board = new Piece[8][8];
    initPawn(player1, player2);
    placePiece('W', 'K', "E1", player1);
    placePiece('W', 'Q', "D1", player1);
    placePiece('W', 'R', "A1", player1);
    placePiece('W', 'R', "H1", player1);
    placePiece('W', 'B', "C1", player1);
    placePiece('W', 'B', "F1", player1);
    placePiece('W', 'H', "B1", player1);
    placePiece('W', 'H', "G1", player1);
    placePiece('B', 'K', "E8", player2);
    placePiece('B', 'Q', "D8", player2);
    placePiece('B', 'R', "A8", player2);
    placePiece('B', 'R', "H8", player2);
    placePiece('B', 'B', "C8", player2);
    placePiece('B', 'B', "F8", player2);
    placePiece('B', 'H', "B8", player2);
    placePiece('B', 'H', "G8", player2);
  }

  public void initPawn(Player player1, Player player2) {
    for (int i = 65; i < 73; i++) {
      char ranks = (char) i;
      placePiece('W', 'P', ranks + "2", player1);
      placePiece('B', 'P', ranks + "7", player2);
    }
  }

  public void placePiece(char side, char role, String AN, Player player) {
    int coord[] = ANtoCoords(AN);
    Piece piece = null;

    switch (role) {
      case 'K':
        piece = new King(side, coord);
        board[coord[0]][coord[1]] = piece;
        break;
      case 'Q':
        piece = new Queen(side, coord);
        board[coord[0]][coord[1]] = piece;
        break;
      case 'R':
        piece = new Rook(side, coord);
        board[coord[0]][coord[1]] = piece;
        break;
      case 'B':
        piece = new Bishop(side, coord);
        board[coord[0]][coord[1]] = piece;
        break;
      case 'H':
        piece = new Knight(side, coord);
        board[coord[0]][coord[1]] = piece;
        break;
      case 'P':
        piece = new Pawn(side, coord);
        board[coord[0]][coord[1]] = piece;
        break;
    }
    player.insertToSet(piece);
  }

  public char movePiece(char side, String fromAN, String toAN, Player opponent) {
    int fromCoord[] = ANtoCoords(fromAN);
    int toCoord[] = ANtoCoords(toAN);
    Piece target = board[fromCoord[0]][fromCoord[1]];

    // the selected AN cannot be empty nor same to desired AN
    if ((target == null) || fromAN.equals(toAN)) return 'N';

    // if the toCoord is out of index boundary invalid move
    if (outOfValidRange(toCoord)) return 'N';

    if (isValidPlayer(side, target) && isValidMove(target, toCoord)) {
      board[fromCoord[0]][fromCoord[1]] = null;
      Piece deadPiece = board[toCoord[0]][toCoord[1]];
      if (deadPiece != null) opponent.removeFromSet(deadPiece);
      board[toCoord[0]][toCoord[1]] = target;
      target.setCoord(toCoord);

      if (target.getRole() == 'K') return 'K';

      if (target.getRole() == 'P') ((Pawn) target).markMoved();

      return 'Y';
    }
    return 'N';
  }

  private boolean outOfValidRange(int[] coord) {
    return ((coord[0] > 7) || (coord[0] < 0) || (coord[1] > 7) || (coord[1] < 0));
  }

  private boolean isValidPlayer(char side, Piece target) {
    if (target.getSide() == side) return true;
    return false;
  }

  public boolean isValidMove(Piece target, int[] toCoord) {
    if (outOfValidRange(toCoord)) return false;
    return target.moveLogic(toCoord, board);
  }

  public boolean isCheckMated(Player opponent, int[] kingCoord) {
    return checkmateDirection(kingCoord, 0, opponent)
        && checkmateDirection(kingCoord, 45, opponent)
        && checkmateDirection(kingCoord, 90, opponent)
        && checkmateDirection(kingCoord, 135, opponent)
        && checkmateDirection(kingCoord, 180, opponent)
        && checkmateDirection(kingCoord, 225, opponent)
        && checkmateDirection(kingCoord, 270, opponent)
        && checkmateDirection(kingCoord, 315, opponent);
  }

  private boolean checkmateDirection(int[] kingCoord, int degree, Player opponent) {
    Piece king = board[kingCoord[0]][kingCoord[1]];
    int[] potentialCoord = getEightDirections(kingCoord, degree);
    if (!isValidMove(king, potentialCoord)) return true;
    
    return (opponent.iterateSetForValidMovement(potentialCoord, this) != null);
  }

  private int[] getEightDirections(int[] coord, int degree) {
    int[] output = {coord[0], coord[1]};
    switch (degree) {
      case 0:
        output = new int[] {coord[0] - 1, coord[1]};
        break;
      case 45:
        output = new int[] {coord[0] - 1, coord[1] + 1};
        break;
      case 90:
        output = new int[] {coord[0], coord[1] + 1};
        break;
      case 135:
        output = new int[] {coord[0] + 1, coord[1] + 1};
        break;
      case 180:
        output = new int[] {coord[0] + 1, coord[1]};
        break;
      case 225:
        output = new int[] {coord[0] + 1, coord[1] - 1};
        break;
      case 270:
        output = new int[] {coord[0], coord[1] - 1};
        break;
      case 315:
        output = new int[] {coord[0] - 1, coord[1] - 1};
        break;
    }
    return output;
  }

  private char getSymbol(Piece piece) {
    char symbol = ' ';

    if (piece.getSide() == 'W') {
      switch (piece.getRole()) {
        case 'K':
          symbol = '♔';
          break;
        case 'Q':
          symbol = '♕';
          break;
        case 'R':
          symbol = '♖';
          break;
        case 'B':
          symbol = '♗';
          break;
        case 'H':
          symbol = '♘';
          break;
        case 'P':
          symbol = '♙';
          break;
      }
    } else {
      switch (piece.getRole()) {
        case 'K':
          symbol = '♚';
          break;
        case 'Q':
          symbol = '♛';
          break;
        case 'R':
          symbol = '♜';
          break;
        case 'B':
          symbol = '♝';
          break;
        case 'H':
          symbol = '♞';
          break;
        case 'P':
          symbol = '♟';
          break;
      }
    }
    return symbol;
  }

  public static int[] ANtoCoords(String AN) {
    char chars[] = AN.toCharArray();
    int ranks = Integer.parseInt(String.valueOf(chars[1])) - 1;
    int files = Character.toLowerCase(chars[0]) - 'a';
    int coord[] = {ranks, files};

    return coord;
  }
}
