import javax.swing.*;
import java.awt.event.*;

public class GameMouseHandler implements MouseMotionListener, MouseListener {
    private JPanel grid;

    public GameMouseHandler(JPanel grid) {
        this.grid = grid;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        GameDisplay.hoveredx = Board.getTileX(mx);
        GameDisplay.hoveredy = Board.getTileY(my);

        grid.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GameDisplay.selectedx == -1 && GameDisplay.selectedy == -1) {
            int mx = e.getX();
            int my = e.getY();
            GameDisplay.selectedx = Board.getTileX(mx);
            GameDisplay.selectedy = Board.getTileY(my);

            if (GameDisplay.pawn.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.pawn.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                Moves.set(GameDisplay.pawn.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
            } else if (GameDisplay.rook.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.rook.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                System.out.println("Rook selected at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
                Moves.set(GameDisplay.rook.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
            } else if (GameDisplay.knight.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.knight.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                System.out.println("Knight selected at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
                Moves.set(GameDisplay.knight.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
            } else if (GameDisplay.bishop.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.bishop.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                System.out.println("Bishop selected at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
                Moves.set(GameDisplay.bishop.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
            } else {
                Moves.set(GameDisplay.pawn.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
            }
            grid.repaint();
        } else {
            if (Moves.isValidMove(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                // move piece
                System.out.println("Move to: " + GameDisplay.hoveredx + ", " + GameDisplay.hoveredy);
                if (GameDisplay.pawn.isOccupiedBlack(GameDisplay.selectedx, GameDisplay.selectedy) || GameDisplay.pawn.isOccupiedWhite(GameDisplay.selectedx, GameDisplay.selectedy)) {
                    if (GameDisplay.pawn.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.pawn.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Pawn.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.rook.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.rook.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Rook.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.knight.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.knight.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Knight.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.bishop.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.bishop.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Bishop.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    }
                    Pawn.move(GameDisplay.selectedx, GameDisplay.selectedy, GameDisplay.hoveredx, GameDisplay.hoveredy);
                } else if (GameDisplay.rook.isOccupiedBlack(GameDisplay.selectedx, GameDisplay.selectedy) || GameDisplay.rook.isOccupiedWhite(GameDisplay.selectedx, GameDisplay.selectedy)) {
                    System.out.println("Rook moving from: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy + " to " + GameDisplay.hoveredx
                            + ", " + GameDisplay.hoveredy);
                    if (GameDisplay.pawn.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.pawn.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        System.out.println("Capturing pawn at: " + GameDisplay.hoveredx + ", " + GameDisplay.hoveredy);
                        Pawn.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.rook.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.rook.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Rook.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.knight.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.knight.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Knight.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.bishop.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.bishop.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Bishop.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    }
                    Rook.move(GameDisplay.selectedx, GameDisplay.selectedy, GameDisplay.hoveredx, GameDisplay.hoveredy);
                } else if (GameDisplay.knight.isOccupiedBlack(GameDisplay.selectedx, GameDisplay.selectedy) || GameDisplay.knight.isOccupiedWhite(GameDisplay.selectedx, GameDisplay.selectedy)) {
                    System.out.println("Knight moving from: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy + " to " + GameDisplay.hoveredx
                            + ", " + GameDisplay.hoveredy);
                    if (GameDisplay.pawn.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.pawn.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Pawn.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.rook.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.rook.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Rook.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.knight.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.knight.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Knight.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.bishop.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.bishop.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Bishop.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    }
                    Knight.move(GameDisplay.selectedx, GameDisplay.selectedy, GameDisplay.hoveredx, GameDisplay.hoveredy);
                } else if (GameDisplay.bishop.isOccupiedBlack(GameDisplay.selectedx, GameDisplay.selectedy) || GameDisplay.bishop.isOccupiedWhite(GameDisplay.selectedx, GameDisplay.selectedy)) {
                    System.out.println("Bishop moving from: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy + " to " + GameDisplay.hoveredx
                            + ", " + GameDisplay.hoveredy);
                    if (GameDisplay.pawn.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.pawn.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Pawn.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.rook.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.rook.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Rook.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.knight.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.knight.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Knight.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    } else if (GameDisplay.bishop.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.bishop.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                        Bishop.capturePiece(GameDisplay.hoveredx, GameDisplay.hoveredy);
                    }
                    Bishop.move(GameDisplay.selectedx, GameDisplay.selectedy, GameDisplay.hoveredx, GameDisplay.hoveredy);
                }
                TurnOrder.nextTurn();
                TurnDisplay.updateTurn();

                GameDisplay.selectedx = -1;
                GameDisplay.selectedy = -1;
                Moves.set(GameDisplay.pawn.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
                grid.repaint();
            } else {
                int mx = e.getX();
                int my = e.getY();
                GameDisplay.selectedx = Board.getTileX(mx);
                GameDisplay.selectedy = Board.getTileY(my);
                if (GameDisplay.pawn.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.pawn.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                    Moves.set(GameDisplay.pawn.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
                } else if (GameDisplay.rook.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.rook.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                    System.out.println("Rook selected at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
                    Moves.set(GameDisplay.rook.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
                } else if (GameDisplay.knight.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.knight.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                    System.out.println("Knight selected at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
                    Moves.set(GameDisplay.knight.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
                } else if (GameDisplay.bishop.isOccupiedBlack(GameDisplay.hoveredx, GameDisplay.hoveredy) || GameDisplay.bishop.isOccupiedWhite(GameDisplay.hoveredx, GameDisplay.hoveredy)) {
                    System.out.println("Bishop selected at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
                    Moves.set(GameDisplay.bishop.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
                } else {
                    Moves.set(GameDisplay.pawn.loadMoves(GameDisplay.selectedx, GameDisplay.selectedy));
                }
                grid.repaint();
            }
        }

        Promote.update(GameDisplay.selectedx, GameDisplay.selectedy);
        if (GameDisplay.pawn.isOccupiedBlack(GameDisplay.selectedx, GameDisplay.selectedy) || GameDisplay.rook.isOccupiedBlack(GameDisplay.selectedx, GameDisplay.selectedy)
                || GameDisplay.knight.isOccupiedBlack(GameDisplay.selectedx, GameDisplay.selectedy) || GameDisplay.bishop.isOccupiedBlack(GameDisplay.selectedx, GameDisplay.selectedy)) {
            System.out.println("Black piece selected at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
        } else if (GameDisplay.pawn.isOccupiedWhite(GameDisplay.selectedx, GameDisplay.selectedy) || GameDisplay.rook.isOccupiedWhite(GameDisplay.selectedx, GameDisplay.selectedy)
                || GameDisplay.knight.isOccupiedWhite(GameDisplay.selectedx, GameDisplay.selectedy) || GameDisplay.bishop.isOccupiedWhite(GameDisplay.selectedx, GameDisplay.selectedy)) {
            System.out.println("White piece selected at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
        } else {
            System.out.println("No piece at: " + GameDisplay.selectedx + ", " + GameDisplay.selectedy);
        }
    }
}