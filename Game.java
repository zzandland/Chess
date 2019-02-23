import piece.Pawn;
import piece.Piece;

public class Game {
  public static void main(String args[]) {
    Board board = new Board();
    board.placePiece('W', 'P', "A2");
    System.out.println(board.getBoard()[0][0]);
    System.out.println(board.getBoard()[1][0]);
    System.out.println(board.getBoard()[0][1]);
  }
}

class Player {
  
}

class Board {
  private Piece board[][] = new Piece[8][8];

  public Piece[][] getBoard() { return board; }

  public void placePiece(char side, char role, String AN) {
    int coord[] = ANtoCoords(AN); 

    switch (role) {
      case 'P':
        Pawn piece = new Pawn(side);
        board[coord[0]][coord[1]] = piece;
        break;
    }
  }

  private static int[] ANtoCoords(String AN) {
    char chars[] = AN.toCharArray();
    int ranks = Integer.parseInt(String.valueOf(chars[1])) - 1;
    int files = Character.toLowerCase(chars[0]) - 'a';
    int coord[] = {ranks, files};
    return coord;
  }

}
