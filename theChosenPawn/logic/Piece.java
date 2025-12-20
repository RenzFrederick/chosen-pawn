package logic;
import java.util.ArrayList;

public abstract class Piece {
    public abstract boolean isOccupiedWhite(int x, int y);
    public abstract boolean isOccupiedBlack(int x, int y);
    public abstract ArrayList<Integer> loadMoves(int x, int y);
    public abstract void promote(int x, int y);
}
