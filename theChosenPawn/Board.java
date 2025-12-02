import java.util.ArrayList;

public class Board {
    static ArrayList<ArrayList<Integer>> occupied;
    public static boolean isOccupied(ArrayList<Integer> position){
        return occupied.contains(position);
    }
    
    public static void setPosition(Piece piece, ArrayList<Integer> position){
        occupied.remove(piece.position);
        occupied.add(position);    
    }

    public static void resetBoard(){
        occupied.clear();
    }


}
