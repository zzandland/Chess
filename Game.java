public class Game {
  public static void initGame() {
    Player player1 = new Player("David", 'W');
    Player player2 = new Player("Sarah", 'B');
    Board.initBoard();    

    Board.printBoard();
    Board.movePiece('B', "B7", "B6");
    Board.printBoard();
    Board.movePiece('B', "B6", "B5");
    Board.printBoard();
    Board.movePiece('B', "B5", "B4");
    Board.printBoard();
    Board.movePiece('B', "B4", "B3");
    Board.printBoard();
    Board.movePiece('B', "B3", "C2");
    Board.printBoard();
  }

  public static void main(String args[]) {
    initGame();
  }
}
