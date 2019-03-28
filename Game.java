import java.io.*;
import piece.*;

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
    board.initBoard(player1, player2);
    player1.setKingPos("E1");
    player2.setKingPos("E8");

    while (!gameOver) {
      takeTurn();
    }
  }

  public void gameOver(Player winner) throws IOException {
    BufferedReader br = Input.generateBR(System.in);
    System.out.println(winner.getName() + " won the Game!");
    gameOver = true;
    // winner.incrementScore();
    // String scoreStr =
        // "Current score:\n"
            // + player1.getName()
            // + ": "
            // + player1.getScore()
            // + "\n"
            // + player2.getName()
            // + ": "
            // + player2.getScore();
    // System.out.println(scoreStr);
    // System.out.println("\nDo you want to play again? (y/n)");
    // String response = br.readLine();
    // if (response.equals("y")) {
      // board = new Board();
      // gameOver = false;
      // whiteTurn = true;
      // initGame();
    // }
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

    if (!current.movePiece(fromAN, toAN, board, opponent)) {
      takeTurn();
    } else {
      if (isChecked(current, opponent, board)) {
        if (isCheckMated(current, opponent, board, toAN)) {
          board.printBoard();
          gameOver(current);
          return;
        } else {
          System.out.println("Check on " + opponent.getName() + "'s King.");
        }
      }
      whiteTurn = !whiteTurn;
    }
  }

  private boolean isChecked(Player current, Player opponent, Board board) {
    return (current.iterateSetForValidMovement(opponent.getKingPos(), board) != null);
  }

  private boolean isCheckMated(Player current, Player opponent, Board board, String checkedAN) {
    Piece piece = opponent.iterateSetForValidMovement(checkedAN, board);
    if (piece != null) {
      return board.isCheckMated(current, piece.getCoord());
    }
    int[] opponentKingCoord = Board.ANtoCoords(opponent.getKingPos());
    return board.isCheckMated(current, opponentKingCoord);
  }
}
