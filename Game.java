import java.io.*;

public class Game {
  private boolean gameOver = false;
  private boolean whiteTurn = true;
  private Player player1;
  private Player player2;
  private Board board;

  public Game() throws IOException {
    setPlayerNames();
    board = new Board();
  }

  public void initGame() throws IOException {
    board.initBoard();
    player1.setKingPos("D1");
    player2.setKingPos("D8");

    while (!gameOver) {
      takeTurn();
    }
  }

  private void setPlayerNames() throws IOException {
    BufferedReader br = Input.generateBR(System.in);

    System.out.println("What is White player's name? Type and press return: ");
    player1 = new Player(br.readLine(), 'W');

    System.out.println("What is Black player's name? Type and press return: ");
    player2 = new Player(br.readLine(), 'B');
  }

  private void takeTurn() throws IOException {
    board.printBoard();

    Player current, opponent;
    String sideName;

    if (whiteTurn) {
      current = player1;
      opponent = player2;
    } else {
      current = player2;
      opponent = player1;
    }

    System.out.println(String.format("It is %s's turn now.", current.getName()));

    BufferedReader br = Input.generateBR(System.in);

    System.out.println(
        "Type the algebraic notation of the chess piece you want to move and press return: ");
    String fromAN = br.readLine();

    System.out.println(
        "Type the algebraic algebraic notation of the destination and press return: ");
    String toAN = br.readLine();

    if (!current.movePiece(fromAN, toAN, board)) {
      takeTurn();
    } else {
      if (isCheck(toAN, opponent.getKingPos()))
        System.out.println("Check on " + opponent.getName() + "'s King.");

      whiteTurn = !whiteTurn;
    }
  }

  private boolean isCheck(String movedAN, String enemyKingAN) {
    return board.isCheck(movedAN, enemyKingAN);
  }
}
