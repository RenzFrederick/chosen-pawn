import java.util.ArrayList;

public abstract class Piece {
    public String rank;
    public int player;
    public boolean chosen;

    public abstract ArrayList<Integer> loadMoves(int x, int y);
    public abstract void promote();
}
