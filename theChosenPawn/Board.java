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

    public static int getTileX(int mx){
        int xstart = (GameDisplay.frame.getWidth()-(5*Constants.cellSize))/2;
        int xend = xstart + (5*Constants.cellSize);   

        if (mx < xend && mx > xstart){
            return (mx - xstart) / Constants.cellSize;
        }
        else {
            return -1;
        }

    }

    public static int getTileY(int my){
        int ystart = (GameDisplay.frame.getHeight()-(5*Constants.cellSize))/3;
        int yend = ystart + (5*Constants.cellSize);   

        if (my < yend && my > ystart){
            return (my - ystart) / Constants.cellSize;
        }
        else {
            return -1;
        }

    }}
   
