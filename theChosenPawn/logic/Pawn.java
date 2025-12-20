package logic;
import java.util.ArrayList;

public class Pawn extends Piece {
    private static ArrayList<Integer> occupiedxw = new ArrayList<Integer>();
    private static ArrayList<Integer> occupiedyw = new ArrayList<Integer>();
    private static ArrayList<Integer> occupiedxb = new ArrayList<Integer>();
    private static ArrayList<Integer> occupiedyb = new ArrayList<Integer>();
    Piece Rook = new Rook();
    Piece Bishop = new Bishop();
    Piece Knight = new Knight();

    public boolean isOccupiedWhite(int x, int y) {
        for (int i = 0; i < occupiedxw.size(); i++) {
            if (occupiedxw.get(i) == x && occupiedyw.get(i) == y) {
                return true;
            }
        }
        return false;
    }

    public boolean isOccupiedBlack(int x, int y) {
        for (int i = 0; i < occupiedxb.size(); i++) {
            if (occupiedxb.get(i) == x && occupiedyb.get(i) == y) {
                return true;
            }
        }
        return false;
    }

    public static void startingBoard() {
        // generate white on left side of board and black on right side
        for (int i = 0; i < 5; i++) {
            occupiedxw.add(0);
            occupiedyw.add(i);
            occupiedxb.add(4);
            occupiedyb.add(i);
        }
    }

    public ArrayList<Integer> loadMoves(int x, int y) {
        ArrayList<Integer> moves = new ArrayList<Integer>();

        if (isOccupiedWhite(x, y) != true && isOccupiedBlack(x, y) != true) {
            return moves;
        } else if (isOccupiedWhite(x, y) && TurnOrder.getTurns() == "White") {
            if (isOccupiedWhite(x + 1, y) != true && isOccupiedBlack(x + 1, y) != true) {
                if (x + 1 <= 4) {
                    moves.add(x + 1);
                    moves.add(y);
                }
            }
            if (isOccupiedBlack(x + 1, y + 1) || Rook.isOccupiedBlack(x + 1, y + 1)
                    || Bishop.isOccupiedBlack(x + 1, y + 1) || Knight.isOccupiedBlack(x + 1, y + 1)) {
                if (x + 1 <= 4) {
                    moves.add(x + 1);
                    moves.add(y + 1);
                }
            }
            if (isOccupiedBlack(x + 1, y - 1) || Rook.isOccupiedBlack(x + 1, y - 1)
                    || Bishop.isOccupiedBlack(x + 1, y - 1) || Knight.isOccupiedBlack(x + 1, y - 1)) {
                if (x + 1 <= 4) {
                    moves.add(x + 1);
                    moves.add(y - 1);
                }
            }
        } else if (isOccupiedBlack(x, y) && TurnOrder.getTurns() == "Black") {
            if (isOccupiedWhite(x - 1, y) != true && isOccupiedBlack(x - 1, y) != true) {
                if (x - 1 >= 0) {
                    moves.add(x - 1);
                    moves.add(y);
                }
            }
            if (isOccupiedWhite(x - 1, y + 1) || Rook.isOccupiedWhite(x - 1, y + 1)
                    || Bishop.isOccupiedWhite(x - 1, y + 1) || Knight.isOccupiedWhite(x - 1, y + 1)) {
                if (x - 1 >= 0) {
                    moves.add(x - 1);
                    moves.add(y + 1);
                }
            }
            if (isOccupiedWhite(x - 1, y - 1) || Rook.isOccupiedWhite(x - 1, y - 1)
                    || Bishop.isOccupiedWhite(x - 1, y - 1) || Knight.isOccupiedWhite(x - 1, y - 1)) {
                if (x - 1 >= 0) {
                    moves.add(x - 1);
                    moves.add(y - 1);
                }
            }
        }
        return moves;
    }

    public void promote(int x, int y) {

    }

    public static void move(int oldx, int oldy, int newx, int newy) {
        Piece pawn = new Pawn();
        // check if oldx and oldy is in white or black occupied list
        if (pawn.isOccupiedWhite(oldx, oldy)) {
            // find index of oldx and oldy in white occupied lists
            for (int i = 0; i < occupiedxw.size(); i++) {
                if (occupiedxw.get(i) == oldx && occupiedyw.get(i) == oldy) {
                    // update to newx and newy
                    occupiedxw.set(i, newx);
                    occupiedyw.set(i, newy);
                    return;
                }
            }
        } else if (pawn.isOccupiedBlack(oldx, oldy)) {
            for (int i = 0; i < occupiedxb.size(); i++) {
                if (occupiedxb.get(i) == oldx && occupiedyb.get(i) == oldy) {
                    // update to newx and newy
                    occupiedxb.set(i, newx);
                    occupiedyb.set(i, newy);
                    return;
                }
            }
        }
    }

    public static void capturePiece(int x, int y) {
        Piece pawn = new Pawn();
        if (pawn.isOccupiedWhite(x, y)) {
            for (int i = 0; i < occupiedxw.size(); i++) {
                if (occupiedxw.get(i) == x && occupiedyw.get(i) == y) {
                    occupiedxw.remove(i);
                    occupiedyw.remove(i);
                    return;
                }
            }
        } else if (pawn.isOccupiedBlack(x, y)) {
            for (int i = 0; i < occupiedxb.size(); i++) {
                if (occupiedxb.get(i) == x && occupiedyb.get(i) == y) {
                    occupiedxb.remove(i);
                    occupiedyb.remove(i);
                    return;
                }
            }
        }
    }

    public boolean hasPromotedwhite() {
        return false;
    }

    public boolean hasPromotedblack() {
        return false;
    }

}
