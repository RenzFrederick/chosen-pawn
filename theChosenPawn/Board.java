import java.util.ArrayList;

public class Board {
    private static ArrayList<Integer> occupiedx = new ArrayList<Integer>();
    private static ArrayList<Integer> occupiedy = new ArrayList<Integer>();
    public static boolean isOccupied(int x, int y){
        ArrayList<Integer> xs = new ArrayList<Integer>();
        ArrayList<Integer> ys = new ArrayList<Integer>(); 
        for (int i = 0; i < occupiedx.size(); i++){
            if (occupiedx.get(i) == x){
                xs.add(i);
            }
        }
        for (int i = 0; i < occupiedy.size(); i++){
            if (occupiedy.get(i) == y){
                ys.add(i);
            }
        }
        
        for (int a : xs) {
            for (int b : ys) {
                if (a == b) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void setPosition(Piece piece, ArrayList<Integer> position){  
    }

    public static void resetBoard(){
        occupiedx.add(0);
        occupiedy.add(0);
        
        occupiedx.add(0);
        occupiedy.add(1);
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

    }

    public class isOccupied {
    }}
   
