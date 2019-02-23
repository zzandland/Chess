public class Game {
  public static void main(String args[]) {
    Player player1 = new Player("David", 'W');
    Board.placePiece('W', 'P', "A1");
    System.out.println("A1: " + Board.getBoard()[0][0]);
    System.out.println("A2: " +Board.getBoard()[1][0]);

    player1.movePiece("A1", "A2");
    System.out.println("A1: " + Board.getBoard()[0][0]);
    System.out.println("A2: " +Board.getBoard()[1][0]);
  }
}
