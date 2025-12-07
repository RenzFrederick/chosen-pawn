import java.util.ArrayList;

public class Pawn extends Piece{
    public String rank = "pawn";
    public int player;
    public boolean chosen;

    public ArrayList<Integer> loadMoves(int x, int y){
        ArrayList<Integer> moves = new ArrayList<Integer>();

        if (player == 0){
            if (Board.isOccupied(x+1, y)) {
                moves.add(x+1);
                moves.add(y);
            } 
        }
        else if (player == 1){
            if (Board.isOccupied(x-1, y)) {
                moves.add(x-1);
                moves.add(y);
            } 
        }

        return moves;
    }
    public void move(){

    }
    public void promote(){

    }
}
