import java.util.ArrayList;

public class Pawn extends Piece{
    public ArrayList<Integer> position;
    public String rank = "pawn";
    public int player;
    public boolean chosen;

    public ArrayList<ArrayList<Integer>> loadMoves(){
        ArrayList<ArrayList<Integer>>moves = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> coordinates = position;
        coordinates.set(0, coordinates.get(0)+1);

        if (player == 0){
            coordinates.set(0, coordinates.get(0)+1);
            if (Board.isOccupied(coordinates)) {
                moves.add(coordinates);
            } 
        }
        else if (player == 1){
            coordinates.set(0, coordinates.get(0)-1);
            if (Board.isOccupied(coordinates)) {
                moves.add(coordinates);
            }
        }

        return moves;
    }
    public void move(){

    }
    public void promote(){

    }
}
