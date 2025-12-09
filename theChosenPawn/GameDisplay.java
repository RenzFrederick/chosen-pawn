import javax.swing.*;
import java.awt.event.*;

import java.io.IOException;

public class GameDisplay{

    //instantiate JFrame
    public static JFrame frame = new JFrame("The Chosen Pawn");
    protected static int hoveredy = -1;
    protected static int hoveredx = -1;
    protected static int selectedx = -1;
    protected static int selectedy = -1;


    public static void main(String[] args) throws IOException{
        Piece pawn = new Pawn();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(342, 683);
        
        Board.resetBoard();

        // custom panel that scales the image to fill the entire window
        JLayeredPane panel = new JLayeredPane();

        ImageIcon backgroundIcon = new ImageIcon("theChosenPawn\\sprites\\background.gif");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.add(backgroundLabel, Integer.valueOf(-1));

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

        //unused implementations
        public void mouseDragged(MouseEvent e) {}
    });

        grid.addMouseListener(new MouseListener() {
            public void mouseExited(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mousePressed(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            
            @Override 
            public void mouseClicked(MouseEvent e){
                if (selectedx == -1 && selectedy == -1) {
                    int mx = e.getX();
                    int my = e.getY();
        
                    selectedx = Board.getTileX(mx);
                    selectedy = Board.getTileY(my);

                    Moves.set(pawn.loadMoves(selectedx, selectedy)); 
                    grid.repaint();
                }
                else {
                    if (Moves.isValidMove(hoveredx, hoveredy)) {
                        //move piece
                        System.out.println("Move to: " + hoveredx + ", " + hoveredy);
                        if (Board.isOccupiedBlack(hoveredx, hoveredy) || Board.isOccupiedWhite(hoveredx, hoveredy)) {
                            Board.capturePiece(hoveredx, hoveredy);
                        }
                        Board.move(selectedx, selectedy, hoveredx, hoveredy);

                        selectedx = -1;
                        selectedy = -1;
                        Moves.set(pawn.loadMoves(selectedx, selectedy));
                        grid.repaint();
                    }
                    else{
                        int mx = e.getX();
                        int my = e.getY();
        
                        selectedx = Board.getTileX(mx);
                        selectedy = Board.getTileY(my);

                        Moves.set(pawn.loadMoves(selectedx, selectedy)); 
                        grid.repaint();
                    }
                }

                

                if (Board.isOccupiedBlack(selectedx, selectedy)) {
                    System.out.println("Black piece selected at: " + selectedx + ", " + selectedy);
                } else if (Board.isOccupiedWhite(selectedx, selectedy)) {
                    System.out.println("White piece selected at: " + selectedx + ", " + selectedy);
                } else {
                    System.out.println("No piece at: " + selectedx + ", " + selectedy);
                }

                
            }
        });

        JPanel pieces = new PieceDisplay();
        grid.setOpaque(false); // let background image show through
        pieces.setOpaque(false);
        
        grid.setBounds(0, 0, 342, 683);
        pieces.setBounds(0, 0, 342, 683);

        panel.add(grid, Integer.valueOf(0));
        panel.add(pieces, Integer.valueOf(1));

        frame.add(panel);
        frame.setVisible(true);
}}
