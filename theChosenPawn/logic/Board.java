package logic;

import java.util.ArrayList;

import gui.GameDisplay;


public class Board {

    private static final Pawn pawn = new Pawn();
    private static final Rook rook = new Rook();
    private static final Bishop bishop = new Bishop();
    private static final Knight knight = new Knight();

    //give tile x and y based on mouse coordinates
    public static int getTileX(int mx) {
        int xstart = (GameDisplay.frame.getWidth() - (5 * Constants.cellSize)) / 2;
        int xend = xstart + (5 * Constants.cellSize);

        if (mx < xend && mx > xstart) {
            return (mx - xstart) / Constants.cellSize;
        } else {
            return -1;
        }

    }
    
    public static int getTileY(int my) {
        int ystart = (GameDisplay.frame.getHeight() - (5 * Constants.cellSize)) / 3;
        int yend = ystart + (5 * Constants.cellSize);

        if (my < yend && my > ystart) {
            return (my - ystart) / Constants.cellSize;
        } else {
            return -1;
        }

    }

    public static boolean pieceAt(int x, int y) {
        if (pawn.isOccupiedBlack(x, y) || pawn.isOccupiedWhite(x, y)
                || rook.isOccupiedBlack(x, y) || rook.isOccupiedWhite(x, y)
                || bishop.isOccupiedBlack(x, y) || bishop.isOccupiedWhite(x, y)
                || knight.isOccupiedBlack(x, y) || knight.isOccupiedWhite(x, y)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean noPiecesLeft(String color) {
        if ("White".equals(color)) {
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (pawn.isOccupiedWhite(x, y) || rook.isOccupiedWhite(x, y)
                            || bishop.isOccupiedWhite(x, y) || knight.isOccupiedWhite(x, y)) {
                        return false; // there is at least one white piece
                    }
                }
            }
            return true; // no white pieces found
        } else if ("Black".equals(color)) {
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (pawn.isOccupiedBlack(x, y) || rook.isOccupiedBlack(x, y)
                            || bishop.isOccupiedBlack(x, y) || knight.isOccupiedBlack(x, y)) {
                        return false; // there is at least one black piece
                    }
                }
            }
            return true; // no black pieces found
        }

        return false;
    }

    public static boolean noMoreMoves(String color) {
        if ("White".equals(color)) {
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (pawn.isOccupiedWhite(x, y)) {
                        ArrayList<Integer> moves = pawn.loadMoves(x, y);
                        if (moves != null && moves.size() > 0)
                            return false;
                    } else if (rook.isOccupiedWhite(x, y)) {
                        ArrayList<Integer> moves = rook.loadMoves(x, y);
                        if (moves != null && moves.size() > 0)
                            return false;
                    }
                }
            }
            return true;
        } else if ("Black".equals(color)) {
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (pawn.isOccupiedBlack(x, y)) {
                        ArrayList<Integer> moves = pawn.loadMoves(x, y);
                        if (moves != null && moves.size() > 0)
                            return false;
                    } else if (rook.isOccupiedBlack(x, y)) {
                        ArrayList<Integer> moves = rook.loadMoves(x, y);
                        if (moves != null && moves.size() > 0)
                            return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
