import java.util.ArrayList;

public class Pawn extends Piece{
    public String rank = "pawn";
    public int player;
    public boolean chosen;

    public ArrayList<Integer> loadMoves(int x, int y){
        ArrayList<Integer> moves = new ArrayList<Integer>();

        if (Board.isOccupiedWhite(x, y) != true && Board.isOccupiedBlack(x, y) != true ){
            return moves;
        }
        else if (Board.isOccupiedWhite(x, y) && (Board.isOccupiedWhite(x+1, y) != true && Board.isOccupiedBlack(x+1, y) != true)) {
                moves.add(x+1);
                moves.add(y);
            } 
        else if (Board.isOccupiedBlack(x, y) && (Board.isOccupiedWhite(x-1, y) != true && Board.isOccupiedBlack(x-1, y) != true)) {
                moves.add(x-1);
                moves.add(y); 
            } 

        return moves;
    }
    
    public void promote(){

    }
}
