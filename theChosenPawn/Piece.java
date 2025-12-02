import java.util.ArrayList;

public abstract class Piece {
    public int[] position;
    public String rank;
    public int player;
    public boolean chosen;

    public abstract ArrayList<ArrayList<Integer>> loadMoves();
    public abstract void move();
    public abstract void promote();
}
