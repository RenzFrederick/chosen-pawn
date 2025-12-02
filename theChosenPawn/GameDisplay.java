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

    public static void main(String[] args) throws IOException{
        // generate window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(342, 683);

        // load image
        final BufferedImage myPicture = ImageIO.read(new File("theChosenPawn/sprites/image.png"));

        // custom panel that scales the image to fill the entire window
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                    g.drawImage(myPicture, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // configure panel as background and add a transparent grid overlay
        panel.setLayout(new java.awt.BorderLayout());

        JPanel grid = new BoardDisplay();
        grid.addMouseMotionListener(new MouseMotionListener() {
        
        @Override
        public void mouseMoved(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
        
            int xstart = (frame.getWidth()-(5*Constants.cellSize))/2;
            int ystart = (frame.getHeight()-(5*Constants.cellSize))/3;


            int xend = xstart + (5*Constants.cellSize);
            int yend = ystart + (5*Constants.cellSize);

            if (mx < xend && my < yend && mx > xstart && my > ystart){
                hoveredx = (mx - xstart) / Constants.cellSize;
                hoveredy = (my - ystart) / Constants.cellSize;
            }
            else {
                hoveredx = -1;
                hoveredy = -1;
            }

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

            //in refactoring, combine these into one method that can be called by different
            @Override 
            public void mouseClicked(MouseEvent e){
                int mx = e.getX();
                int my = e.getY();
        
                int xstart = (frame.getWidth()-(5*Constants.cellSize))/2;
                int ystart = (frame.getHeight()-(5*Constants.cellSize))/3;


                int xend = xstart + (5*Constants.cellSize);   
                int yend = ystart + (5*Constants.cellSize);

                if (mx < xend && my < yend && mx > xstart && my > ystart){
                    selectedx = (mx - xstart) / Constants.cellSize;
                    selectedy = (my - ystart) / Constants.cellSize;
               }
                else {
                    selectedx = -1;
                    selectedy = -1;
                }

                grid.repaint();
            }
        });

        grid.setOpaque(false); // let background image show through

        panel.add(grid, java.awt.BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
}}
