import piece.Pawn;
import piece.Piece;

public class Game {

  public static void main(String args[]) {
    Pawn pawn = new Pawn('W', "A2");
    int origin = Piece.generateIntCoord(pawn.getCoord());
    System.out.println(origin);
    System.out.println(Piece.getMap().get(origin));
    System.out.println(pawn.move("A3"));
    System.out.println(Piece.getMap().get(10));
    System.out.println(Piece.getMap().get(20));
  }
}

class Player {
  
}

class Board {
  private String board[][];

  public Board() {
    board = new String[8][8];
  }
}
