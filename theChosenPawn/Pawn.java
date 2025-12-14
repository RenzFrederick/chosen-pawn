import java.util.ArrayList;

public class Pawn extends Piece {
    public String rank = "pawn";
    public int player;
    public boolean chosen;

    public ArrayList<Integer> loadMoves(int x, int y) {
        ArrayList<Integer> moves = new ArrayList<Integer>();

        if (Board.isOccupiedWhite(x, y) != true && Board.isOccupiedBlack(x, y) != true) {
            return moves;
        } else if (Board.isOccupiedWhite(x, y) && TurnOrder.getTurns() == "White") {
            if (Board.isOccupiedWhite(x + 1, y) != true && Board.isOccupiedBlack(x + 1, y) != true) {
                if (x + 1 <= 4) {
                    moves.add(x + 1);
                    moves.add(y);
                }
            }
            if (Board.isOccupiedBlack(x + 1, y + 1)) {
                if (x + 1 <= 4) {
                    moves.add(x + 1);
                    moves.add(y + 1);
                }
            }
            if (Board.isOccupiedBlack(x + 1, y - 1)) {
                if (x + 1 <= 4) {
                    moves.add(x + 1);
                    moves.add(y - 1);
                }
            }
        } else if (Board.isOccupiedBlack(x, y) && TurnOrder.getTurns() == "Black") {
            if (Board.isOccupiedWhite(x - 1, y) != true && Board.isOccupiedBlack(x - 1, y) != true) {
                if (x - 1 >= 0) {
                    moves.add(x - 1);
                    moves.add(y);
                }
            }
            if (Board.isOccupiedWhite(x - 1, y + 1)) {
                if (x - 1 >= 0) {
                    moves.add(x - 1);
                    moves.add(y + 1);
                }
            }
            if (Board.isOccupiedWhite(x - 1, y - 1)) {
                if (x - 1 >= 0) {
                    moves.add(x - 1);
                    moves.add(y - 1);
                }
            }
        }
        return moves;
    }

    public void promote() {

    }
}
