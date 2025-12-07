import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PieceDisplay extends JPanel {
    private BufferedImage blackPawn;

    public PieceDisplay() throws IOException {
        blackPawn = ImageIO.read(new File("sprites/blackpawn.png"));
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        int xstart = (getWidth()-(5*Constants.cellSize))/2;
        int ystart = (getHeight()-(5*Constants.cellSize))/3;
        for (int x = xstart; x < xstart+(5*Constants.cellSize); x += Constants.cellSize) {
            for (int y = ystart; y < ystart+(5*Constants.cellSize); y += Constants.cellSize) {
                if (Board.isOccupied((x - xstart) / Constants.cellSize, (y - ystart) / Constants.cellSize)) {
                    g.drawImage(blackPawn, x, y, Constants.cellSize, Constants.cellSize, this);
                }
            }
        }
    }
}
