public class Game {
  public static void initGame() {
    Player player1 = new Player("David", 'W');
    Player player2 = new Player("Sarah", 'B');
    Board.initBoard();    
  }

  public static void main(String args[]) {
    initGame();
  }
}
