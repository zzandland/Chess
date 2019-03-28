import java.util.HashSet;
import java.util.Iterator;
import piece.*;

public class Player {
  private String name;
  private char side;
  private int score = 0;
  private String kingAN;
  private HashSet<Piece> pieceSet;

  public Player(String name, char side) {
    this.name = name;
    this.side = side;
    this.pieceSet = new HashSet<Piece>();
  }

  public String getName() {
    return name;
  }

  public char getSide() {
    return side;
  }

  public int getScore() {
    return score;
  }

  public void incrementScore() {
    score++;
  }

  public String getKingPos() {
    return kingAN;
  }

  public void setKingPos(String kingAN) {
    this.kingAN = kingAN;
  }

  public void insertToSet(Piece piece) {
    pieceSet.add(piece);
  }

  public void removeFromSet(Piece piece) {
    pieceSet.remove(piece);
  }

  public Piece iterateSetForValidMovement(String toAN, Board board) {
    for (Iterator<Piece> it = pieceSet.iterator(); it.hasNext(); ) {
      Piece piece = it.next();
      int[] toCoord = Board.ANtoCoords(toAN);
      if (board.isValidMove(piece, toCoord)) {
        return piece;
      }
    }
    return null;
  }

  public Piece iterateSetForValidMovement(int[] toCoord, Board board) {
    for (Iterator<Piece> it = pieceSet.iterator(); it.hasNext(); ) {
      Piece piece = it.next();
      if (board.isValidMove(piece, toCoord)) {
        return piece;
      }
    }
    return null;
  }

  public boolean movePiece(String fromAN, String toAN, Board board, Player opponent) {
    char result = board.movePiece(side, fromAN, toAN, opponent);

    if (result != 'N') {
      if (result == 'K') kingAN = toAN;
      return true;
    }
    System.out.println("Invalid move. Please try again.");
    return false;
  }
}
