public class Game {
  public static void main(String args[]) {
    Player player1 = new Player("David", 'W');
    Board.placePiece('W', 'P', "A1");
    Board.printBoard();

    player1.movePiece("A1", "A2");
    Board.printBoard();

    player1.movePiece("A2", "A3");
    Board.printBoard();
  }
}
