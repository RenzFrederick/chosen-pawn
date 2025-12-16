import java.util.ArrayList;

public class Knight extends Piece {
    public static int bx = -1, by = -1, wx = -1, wy = -1;

    public boolean isOccupiedWhite(int x, int y) {
        if (wx == x && wy == y) {
            return true;
        }
        return false;
    }

    public boolean isOccupiedBlack(int x, int y) {
        if (bx == x && by == y) {
            return true;
        }
        return false;
    }

    public ArrayList<Integer> loadMoves(int x, int y){
        Pawn pawn = new Pawn();
        Bishop bishop = new Bishop();
        Rook rook = new Rook();
        ArrayList<Integer> moves = new ArrayList<Integer>();

        // Ensure a bishop exists at the given coordinates
        if (!((x == bx && y == by) || (x == wx && y == wy))) {
            return moves;
        }

        String turn = TurnOrder.getTurns();
        boolean whiteTurn = "White".equals(turn);

        // Directions: NE, NW, SE, SW
        int[][] dirs = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};

        if (whiteTurn && x == wx && y == wy) {
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                    if (pawn.isOccupiedWhite(nx, ny) || isOccupiedWhite(nx, ny)
                    || rook.isOccupiedWhite(nx, ny) || bishop.isOccupiedWhite(nx, ny)) {
                        break;
                    }
                    if (pawn.isOccupiedBlack(nx, ny) || isOccupiedBlack(nx, ny)
                    || rook.isOccupiedBlack(nx, ny) || bishop.isOccupiedBlack(nx, ny)) {
                        moves.add(nx);
                        moves.add(ny);
                        break;
                    }
                    moves.add(nx);
                    moves.add(ny);
            }
        } else if (!whiteTurn && x == bx && y == by) {
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                    if (pawn.isOccupiedBlack(nx, ny) || isOccupiedBlack(nx, ny)
                    || rook.isOccupiedBlack(nx, ny) || bishop.isOccupiedBlack(nx, ny)) {
                        break;
                    }
                    if (pawn.isOccupiedWhite(nx, ny) || isOccupiedWhite(nx, ny)
                    || rook.isOccupiedWhite(nx, ny) || bishop.isOccupiedWhite(nx, ny)) {
                        moves.add(nx);
                        moves.add(ny);
                        break;
                    }
                    moves.add(nx);
                    moves.add(ny);
                    nx += d[0];
                    ny += d[1];
            }
        }

        System.out.println("Bishop moves: " + moves);
        return moves;
    }

    public void promote(int x, int y){
        Piece pawn = new Pawn();
        if (pawn.isOccupiedBlack(x, y) && bx == -1 && by == -1){
            Pawn.capturePiece(x, y);
            bx = x;
            by = y;
        } else if (pawn.isOccupiedWhite(x, y) && wx == -1 && wy == -1){
            Pawn.capturePiece(x, y);
            wx = x;
            wy = y;
        }
    }

    public static void move(int oldx, int oldy, int newx, int newy) {
        System.out.println("Rook moved from: " + oldx + ", " + oldy + " to " + newx + ", " + newy);
        // check which color the rook belongs to
            if (wx == oldx && wy == oldy) {
                wx = newx;
                wy = newy;
        } else if (bx == oldx && by == oldy) {
                bx = newx;
                by = newy;
            }
    
        }
        
    public static void capturePiece(int x, int y) {
        System.out.println("Rook captured at: " + x + ", " + y);
        if (wx == x && wy == y) {
            wx = -2;
            wy = -2;
        } else if (bx == x && by == y) {
            bx = -2;
            by = -2;
        }
    }
    
}
