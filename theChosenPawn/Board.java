import java.util.ArrayList;

public class Board {
    private static ArrayList<Integer> occupiedxw = new ArrayList<Integer>();
    private static ArrayList<Integer> occupiedyw = new ArrayList<Integer>();
    private static ArrayList<Integer> occupiedxb = new ArrayList<Integer>();
    private static ArrayList<Integer> occupiedyb = new ArrayList<Integer>();
    public static boolean isOccupiedWhite(int x, int y){
        for (int i = 0; i < occupiedxw.size(); i++){
                if (occupiedxw.get(i) == x && Board.occupiedyw.get(i) == y){
                    return true;
                }}
                return false;
    }

    public static boolean isOccupiedBlack(int x, int y){
       for (int i = 0; i < occupiedxb.size(); i++){
                if (occupiedxb.get(i) == x && Board.occupiedyb.get(i) == y){
                    return true;
                }}
                return false;
    }

    public static void resetBoard(){
        //generate white on left side of board and black on right side
        for (int i = 0; i < 5; i++){
            occupiedxw.add(0);
            occupiedyw.add(i);
            occupiedxb.add(4);
            occupiedyb.add(i);
        }
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

    public static void move(int oldx, int oldy, int newx, int newy){
        //check if oldx and oldy is in white or black occupied list
        if (isOccupiedWhite(oldx, oldy)){
            //find index of oldx and oldy in white occupied lists
            for (int i = 0; i < occupiedxw.size(); i++){
                if (occupiedxw.get(i) == oldx && Board.occupiedyw.get(i) == oldy){
                    //update to newx and newy
                    occupiedxw.set(i, newx);
                    occupiedyw.set(i, newy);
                    return;
                }
            }
        }
        else if (isOccupiedBlack(oldx, oldy)){
            for (int i = 0; i < Board.occupiedxb.size(); i++){
                if (occupiedxb.get(i) == oldx && Board.occupiedyb.get(i) == oldy){
                    //update to newx and newy
                    occupiedxb.set(i, newx);
                    occupiedyb.set(i, newy);
                    return;
                }
            }
        }
    }

    public static void capturePiece(int x, int y){
        if (isOccupiedWhite(x, y)){
            for (int i = 0; i < occupiedxw.size(); i++){
                if (occupiedxw.get(i) == x && Board.occupiedyw.get(i) == y){
                    occupiedxw.remove(i);
                    occupiedyw.remove(i);
                    return;
                }
            }
        }
        else if (isOccupiedBlack(x, y)){
            for (int i = 0; i < Board.occupiedxb.size(); i++){
                if (occupiedxb.get(i) == x && Board.occupiedyb.get(i) == y){
                    occupiedxb.remove(i);
                    occupiedyb.remove(i);
                    return;
                }
            }
        }
    }
}
