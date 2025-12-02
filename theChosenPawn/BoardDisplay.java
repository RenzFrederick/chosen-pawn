import javax.swing.*;

public class BoardDisplay extends JPanel{
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                int counter = 0;
                int xstart = (getWidth()-(5*Constants.cellSize))/2;
                int ystart = (getHeight()-(5*Constants.cellSize))/3;
                for (int x = xstart; x < xstart+(5*Constants.cellSize); x += Constants.cellSize) {
                    for (int y = ystart; y < ystart+(5*Constants.cellSize); y += Constants.cellSize) {
                        if (counter%2 == 0) {
                            g.setColor(new java.awt.Color(120, 180, 120)); 
                        } else {
                            g.setColor(new java.awt.Color(255, 255, 230)); 
                        }
                        if (((x - xstart) / Constants.cellSize == GameDisplay.hoveredx) && ((y - ystart) / Constants.cellSize == GameDisplay.hoveredy)){
                            g.setColor(new java.awt.Color(255, 230, 230));
                        }
                        if (((x - xstart) / Constants.cellSize == GameDisplay.selectedx) && ((y - ystart) / Constants.cellSize == GameDisplay.selectedy)){
                            g.setColor(new java.awt.Color(255, 200, 200));
                        }
                        g.fillRect(x, y, Constants.cellSize, Constants.cellSize); // Draw each cell
                        counter++;
                    }
                }
                
            }
}
