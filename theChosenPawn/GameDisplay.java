import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameDisplay{

    public static int cellSize = 51; // Size of each cell
    public static JFrame frame = new JFrame("The Chosen Pawn");
    private static int hoveredRow = -1;
    private static int hoveredCol = -1;

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

        JPanel grid = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                int counter = 0;
                int xstart = (getWidth()-(5*cellSize))/2;
                int ystart = (getHeight()-(5*cellSize))/3;
                for (int x = xstart; x < xstart+(5*cellSize); x += cellSize) {
                    for (int y = ystart; y < ystart+(5*cellSize); y += cellSize) {
                        if (counter%2 == 0) {
                            g.setColor(new java.awt.Color(120, 180, 120)); 
                        } else {
                            g.setColor(new java.awt.Color(255, 255, 230)); 
                        }
                        if (((x - xstart) / cellSize == hoveredCol) && ((y - ystart) / cellSize == hoveredRow)){
                            g.setColor(new java.awt.Color(255, 230, 230));
                        }
                        g.fillRect(x, y, cellSize, cellSize); // Draw each cell
                        counter++;
                    }
                }
                
            }
    };

        grid.addMouseMotionListener(new MouseMotionListener() {
        
        @Override
        public void mouseMoved(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
        
            int xstart = (frame.getWidth()-(5*cellSize))/2;
            int ystart = (frame.getHeight()-(5*cellSize))/3;


            int xend = xstart + (5*cellSize);
            int yend = ystart + (5*cellSize);

            if (mx < xend && my < yend && mx > xstart && my > ystart){
                hoveredCol = (mx - xstart) / cellSize;
                hoveredRow = (my - ystart) / cellSize;
            }
            else {
                hoveredCol = -1;
                hoveredRow = -1;
            }

            grid.repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
        }
    });

        grid.addMouseListener(new MouseListener() {

        });

        grid.setOpaque(false); // let background image show through

        panel.add(grid, java.awt.BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
}}
