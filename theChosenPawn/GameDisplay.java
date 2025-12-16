import javax.swing.*;
import java.awt.event.*;

import java.io.IOException;

public class GameDisplay {

    // instantiate JFrame
    public static JFrame frame = new JFrame("The Chosen Pawn");
    protected static int hoveredy = -1;
    protected static int hoveredx = -1;
    protected static int selectedx = -1;
    protected static int selectedy = -1;

    public static int getSelectedX() {
        return selectedx;
    }

    public static int getSelectedY() {
        return selectedy;
    }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(342, 683);
        Piece pawn = new Pawn();
        Piece rook = new Rook();
        Piece knight = new Knight();
        Piece bishop = new Bishop();
        Promote.update(selectedx, selectedy);
        Pawn.startingBoard();

        // custom panel that scales the image to fill the entire window
        JLayeredPane panel = new JLayeredPane();

        ImageIcon backgroundIcon = new ImageIcon("theChosenPawn\\sprites\\background.gif");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.add(backgroundLabel, Integer.valueOf(-1));

        // label to show which turn it is
        JLabel turn = new TurnDisplay();

        // configure panel as background and add a transparent grid overlay
        panel.setLayout(null);

        JPanel grid = new BoardDisplay();
        grid.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {
                int mx = e.getX();
                int my = e.getY();

                hoveredx = Board.getTileX(mx);
                hoveredy = Board.getTileY(my);

                grid.repaint();
            }

            // unused implementations
            public void mouseDragged(MouseEvent e) {
            }
        });

        grid.addMouseListener(new MouseListener() {
            public void mouseExited(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedx == -1 && selectedy == -1) {
                    int mx = e.getX();
                    int my = e.getY();
                    selectedx = Board.getTileX(mx);
                    selectedy = Board.getTileY(my);

                    if (pawn.isOccupiedBlack(hoveredx, hoveredy) || pawn.isOccupiedWhite(hoveredx, hoveredy)) {
                        Moves.set(pawn.loadMoves(selectedx, selectedy));
                    } else if (rook.isOccupiedBlack(hoveredx, hoveredy) || rook.isOccupiedWhite(hoveredx, hoveredy)) {
                        System.out.println("Rook selected at: " + selectedx + ", " + selectedy);
                        Moves.set(rook.loadMoves(selectedx, selectedy));
                    } else if (knight.isOccupiedBlack(hoveredx, hoveredy) || knight.isOccupiedWhite(hoveredx, hoveredy)) {
                        System.out.println("Knight selected at: " + selectedx + ", " + selectedy);
                        Moves.set(knight.loadMoves(selectedx, selectedy));
                    } else if (bishop.isOccupiedBlack(hoveredx, hoveredy) || bishop.isOccupiedWhite(hoveredx, hoveredy)) {
                        System.out.println("Bishop selected at: " + selectedx + ", " + selectedy);
                        Moves.set(bishop.loadMoves(selectedx, selectedy));
                    } else {
                        Moves.set(pawn.loadMoves(selectedx, selectedy));
                    }
                    grid.repaint();
                } else {
                    if (Moves.isValidMove(hoveredx, hoveredy)) {
                        // move piece
                        System.out.println("Move to: " + hoveredx + ", " + hoveredy);
                        if (pawn.isOccupiedBlack(selectedx, selectedy) || pawn.isOccupiedWhite(selectedx, selectedy)) {
                            if (pawn.isOccupiedBlack(hoveredx, hoveredy) || pawn.isOccupiedWhite(hoveredx, hoveredy)) {
                                Pawn.capturePiece(hoveredx, hoveredy);
                            } else if (rook.isOccupiedBlack(hoveredx, hoveredy) || rook.isOccupiedWhite(hoveredx, hoveredy)) {
                                Rook.capturePiece(hoveredx, hoveredy);
                            } else if (knight.isOccupiedBlack(hoveredx, hoveredy) || knight.isOccupiedWhite(hoveredx, hoveredy)) {
                                Knight.capturePiece(hoveredx, hoveredy);
                            } else if (bishop.isOccupiedBlack(hoveredx, hoveredy) || bishop.isOccupiedWhite(hoveredx, hoveredy)) {
                                Bishop.capturePiece(hoveredx, hoveredy);
                            }
                            Pawn.move(selectedx, selectedy, hoveredx, hoveredy);
                        } else if (rook.isOccupiedBlack(selectedx, selectedy) || rook.isOccupiedWhite(selectedx, selectedy)) {
                            System.out.println("Rook moving from: " + selectedx + ", " + selectedy + " to " + hoveredx
                                    + ", " + hoveredy);
                            if (pawn.isOccupiedBlack(hoveredx, hoveredy) || pawn.isOccupiedWhite(hoveredx, hoveredy)) {
                                System.out.println("Capturing pawn at: " + hoveredx + ", " + hoveredy);
                                Pawn.capturePiece(hoveredx, hoveredy);
                            } else if (rook.isOccupiedBlack(hoveredx, hoveredy) || rook.isOccupiedWhite(hoveredx, hoveredy)) {
                                Rook.capturePiece(hoveredx, hoveredy);
                            } else if (knight.isOccupiedBlack(hoveredx, hoveredy) || knight.isOccupiedWhite(hoveredx, hoveredy)) {
                                Knight.capturePiece(hoveredx, hoveredy);
                            } else if (bishop.isOccupiedBlack(hoveredx, hoveredy) || bishop.isOccupiedWhite(hoveredx, hoveredy)) {
                                Bishop.capturePiece(hoveredx, hoveredy);
                            }
                            Rook.move(selectedx, selectedy, hoveredx, hoveredy);
                        } else if (knight.isOccupiedBlack(selectedx, selectedy) || knight.isOccupiedWhite(selectedx, selectedy)) {
                            System.out.println("Knight moving from: " + selectedx + ", " + selectedy + " to " + hoveredx
                                    + ", " + hoveredy);
                            if (pawn.isOccupiedBlack(hoveredx, hoveredy) || pawn.isOccupiedWhite(hoveredx, hoveredy)) {
                                Pawn.capturePiece(hoveredx, hoveredy);
                            } else if (rook.isOccupiedBlack(hoveredx, hoveredy) || rook.isOccupiedWhite(hoveredx, hoveredy)) {
                                Rook.capturePiece(hoveredx, hoveredy);
                            } else if (knight.isOccupiedBlack(hoveredx, hoveredy) || knight.isOccupiedWhite(hoveredx, hoveredy)) {
                                Knight.capturePiece(hoveredx, hoveredy);
                            } else if (bishop.isOccupiedBlack(hoveredx, hoveredy) || bishop.isOccupiedWhite(hoveredx, hoveredy)) {
                                Bishop.capturePiece(hoveredx, hoveredy);
                            }
                            Knight.move(selectedx, selectedy, hoveredx, hoveredy);
                        } else if (bishop.isOccupiedBlack(selectedx, selectedy) || bishop.isOccupiedWhite(selectedx, selectedy)) {
                            System.out.println("Bishop moving from: " + selectedx + ", " + selectedy + " to " + hoveredx
                                    + ", " + hoveredy);
                            if (pawn.isOccupiedBlack(hoveredx, hoveredy) || pawn.isOccupiedWhite(hoveredx, hoveredy)) {
                                Pawn.capturePiece(hoveredx, hoveredy);
                            } else if (rook.isOccupiedBlack(hoveredx, hoveredy) || rook.isOccupiedWhite(hoveredx, hoveredy)) {
                                Rook.capturePiece(hoveredx, hoveredy);
                            } else if (knight.isOccupiedBlack(hoveredx, hoveredy) || knight.isOccupiedWhite(hoveredx, hoveredy)) {
                                Knight.capturePiece(hoveredx, hoveredy);
                            } else if (bishop.isOccupiedBlack(hoveredx, hoveredy) || bishop.isOccupiedWhite(hoveredx, hoveredy)) {
                                Bishop.capturePiece(hoveredx, hoveredy);
                            }
                            Bishop.move(selectedx, selectedy, hoveredx, hoveredy);
                        }
                        TurnOrder.nextTurn();
                        TurnDisplay.updateTurn();

                        selectedx = -1;
                        selectedy = -1;
                        Moves.set(pawn.loadMoves(selectedx, selectedy));
                        grid.repaint();
                    } else {
                        int mx = e.getX();
                        int my = e.getY();
                        selectedx = Board.getTileX(mx);
                        selectedy = Board.getTileY(my);
                        if (pawn.isOccupiedBlack(hoveredx, hoveredy) || pawn.isOccupiedWhite(hoveredx, hoveredy)) {
                            Moves.set(pawn.loadMoves(selectedx, selectedy));
                        } else if (rook.isOccupiedBlack(hoveredx, hoveredy) || rook.isOccupiedWhite(hoveredx, hoveredy)) {
                            System.out.println("Rook selected at: " + selectedx + ", " + selectedy);
                            Moves.set(rook.loadMoves(selectedx, selectedy));
                        } else if (knight.isOccupiedBlack(hoveredx, hoveredy) || knight.isOccupiedWhite(hoveredx, hoveredy)) {
                            System.out.println("Knight selected at: " + selectedx + ", " + selectedy);
                            Moves.set(knight.loadMoves(selectedx, selectedy));
                        } else if (bishop.isOccupiedBlack(hoveredx, hoveredy) || bishop.isOccupiedWhite(hoveredx, hoveredy)) {
                            System.out.println("Bishop selected at: " + selectedx + ", " + selectedy);
                            Moves.set(bishop.loadMoves(selectedx, selectedy));
                        } else {
                            Moves.set(pawn.loadMoves(selectedx, selectedy));
                        }
                        grid.repaint();
                    }
                }

                Promote.update(selectedx, selectedy);
                if (pawn.isOccupiedBlack(selectedx, selectedy) || rook.isOccupiedBlack(selectedx, selectedy)
                        || knight.isOccupiedBlack(selectedx, selectedy) || bishop.isOccupiedBlack(selectedx, selectedy)) {
                    System.out.println("Black piece selected at: " + selectedx + ", " + selectedy);
                } else if (pawn.isOccupiedWhite(selectedx, selectedy) || rook.isOccupiedWhite(selectedx, selectedy)
                        || knight.isOccupiedWhite(selectedx, selectedy) || bishop.isOccupiedWhite(selectedx, selectedy)) {
                    System.out.println("White piece selected at: " + selectedx + ", " + selectedy);
                } else {
                    System.out.println("No piece at: " + selectedx + ", " + selectedy);
                }

            }
        });

        JPanel pieces = new PieceDisplay();
        JPanel promoteButton = new Promote();

        grid.setOpaque(false); // let background image show through
        pieces.setOpaque(false);

        grid.setBounds(0, 0, 342, 683);
        pieces.setBounds(0, 0, 342, 683);
        turn.setBounds(0, 0, 300, 80);
        promoteButton.setBounds(frame.getWidth() / 3, frame.getHeight() / 2 + frame.getHeight() / 6, 100, 300);
        promoteButton.setOpaque(false);

        panel.add(grid, Integer.valueOf(0));
        panel.add(pieces, Integer.valueOf(1));
        panel.add(turn, Integer.valueOf(2));
        panel.add(promoteButton, Integer.valueOf(3));

        frame.add(panel);
        frame.setVisible(true);
    }
}
