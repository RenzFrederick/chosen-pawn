import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameDisplay{

    //instantiate JFrame
    public static JFrame frame = new JFrame("The Chosen Pawn");
    protected static int hoveredy = -1;
    protected static int hoveredx = -1;
    protected static int selectedx = -1;
    protected static int selectedy = -1;
    final BufferedImage whitePawn = null;
    final BufferedImage blackPawn = null;


    public static void main(String[] args) throws IOException{
        // generate window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(342, 683);
        
        Board.resetBoard();
        

        // load images
        final BufferedImage myPicture = ImageIO.read(new File("sprites\\background.png"));
        //final BufferedImage whitePawn = ImageIO.read(new File("theChosenPawn/sprites/whitepawn.png"));

        // custom panel that scales the image to fill the entire window
        JLayeredPane panel = new JLayeredPane() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                    g.drawImage(myPicture, 0, 0, getWidth(), getHeight(), this);
            }
        };

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
                int mx = e.getX();
                int my = e.getY();
        
                selectedx = Board.getTileX(mx);
                selectedy = Board.getTileY(my);
                grid.repaint();
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
