import piece.Pawn;

public class Game {

  public static void main(String args[]) {
    Pawn pawn = new Pawn(0, 0);
    System.out.println(pawn.getRole());
  }
}

class Player {
  
}

class Board {
  private char[][] board;

  public Board() {
    board = new char[8][8];
  }
}
