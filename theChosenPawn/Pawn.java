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
        else if (Board.isOccupiedWhite(x, y)) {
            if (Board.isOccupiedWhite(x+1, y) != true && Board.isOccupiedBlack(x+1, y) != true) {
                moves.add(x+1);
                moves.add(y);
            }
            if (Board.isOccupiedBlack(x+1, y+1)){
                moves.add(x+1);
                moves.add(y+1);
            }
            if (Board.isOccupiedBlack(x+1, y-1)){
                moves.add(x+1);
                moves.add(y-1);
            }
        }
        else if (Board.isOccupiedBlack(x, y)) {
            if (Board.isOccupiedWhite(x-1, y) != true && Board.isOccupiedBlack(x-1, y) != true) {
                moves.add(x-1);
                moves.add(y); 
            }
            if (Board.isOccupiedWhite(x-1, y+1)){
                moves.add(x-1);
                moves.add(y+1);
            }
            if (Board.isOccupiedWhite(x-1, y-1)){
                moves.add(x-1);
                moves.add(y-1);
            } 
        }
        return moves;
    }
    
    public void promote(){

    }
}
