import java.util.ArrayList;

public class Moves {
    private static ArrayList<Integer> movesx = new ArrayList<Integer>();
    private static ArrayList<Integer> movesy = new ArrayList<Integer>();

    // recieves moves from pawn class loadMoves method
    public static void set(ArrayList<Integer> positions) {
        if (movesx.size() > 0) {
            movesx.clear();
        }
        if (movesy.size() > 0) {
            movesy.clear();
        }
        // extract x and y from positions
        for (int i = 0; i < positions.size(); i += 2) {
            movesx.add(positions.get(i));
            movesy.add(positions.get(i + 1));
        }

    }

    public static boolean isValidMove(int x, int y) {
        for (int i = 0; i < movesx.size(); i++) {
            if (movesx.get(i) == x && movesy.get(i) == y) {
                return true;
            }
        }
        return false;
    }
}