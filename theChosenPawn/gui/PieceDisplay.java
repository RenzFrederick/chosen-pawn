package gui;
import javax.imageio.ImageIO;
import javax.swing.*;

import logic.Bishop;
import logic.Constants;
import logic.Knight;
import logic.Pawn;
import logic.Piece;
import logic.Rook;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PieceDisplay extends JPanel {
    private BufferedImage blackPawn;
    private BufferedImage whitePawn;
    private BufferedImage blackRook;
    private BufferedImage whiteRook;
    private BufferedImage blackBishop;
    private BufferedImage whiteBishop;
    private BufferedImage blackKnight;
    private BufferedImage whiteKnight;
    
    public PieceDisplay() throws IOException {
        blackPawn = ImageIO.read(new File("theChosenPawn\\sprites\\blackpawn.png"));
        whitePawn = ImageIO.read(new File("theChosenPawn\\sprites\\whitepawn.png"));
        blackRook = ImageIO.read(new File("theChosenPawn\\sprites\\blackrook.png"));
        whiteRook = ImageIO.read(new File("theChosenPawn\\sprites\\whiterook.png"));
        blackBishop = ImageIO.read(new File("theChosenPawn\\sprites\\blackBishop.png"));
        whiteBishop = ImageIO.read(new File("theChosenPawn\\sprites\\whiteBishop.png"));
        blackKnight = ImageIO.read(new File("theChosenPawn\\sprites\\blackKnight.png"));
        whiteKnight = ImageIO.read(new File("theChosenPawn\\sprites\\whiteKnight.png"));
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Piece Pawn = new Pawn();
        Piece Rook = new Rook();
        Piece Bishop = new Bishop();
        Piece Knight = new Knight();
        int xstart = (getWidth() - (5 * Constants.cellSize)) / 2;
        int ystart = (getHeight() - (5 * Constants.cellSize)) / 3;
        for (int x = xstart; x < xstart + (5 * Constants.cellSize); x += Constants.cellSize) {
            for (int y = ystart; y < ystart + (5 * Constants.cellSize); y += Constants.cellSize) {
                if (Pawn.isOccupiedBlack((x - xstart) / Constants.cellSize, (y - ystart) / Constants.cellSize)) {
                    g.drawImage(blackPawn, x, y, Constants.cellSize, Constants.cellSize, this);
                } else if (Pawn.isOccupiedWhite((x - xstart) / Constants.cellSize,
                        (y - ystart) / Constants.cellSize)) {
                    g.drawImage(whitePawn, x, y, Constants.cellSize, Constants.cellSize, this);
                } else if (Rook.isOccupiedBlack((x - xstart) / Constants.cellSize,
                        (y - ystart) / Constants.cellSize)){
                        g.drawImage(blackRook, x, y, Constants.cellSize, Constants.cellSize, this);
                } else if (Rook.isOccupiedWhite((x - xstart) / Constants.cellSize,
                        (y - ystart) / Constants.cellSize)){
                        g.drawImage(whiteRook, x, y, Constants.cellSize, Constants.cellSize, this);
                } else if (Knight.isOccupiedBlack((x - xstart) / Constants.cellSize,
                        (y - ystart) / Constants.cellSize)){
                        g.drawImage(blackKnight, x, y, Constants.cellSize, Constants.cellSize, this);
                } else if (Knight.isOccupiedWhite((x - xstart) / Constants.cellSize,
                        (y - ystart) / Constants.cellSize)){
                        g.drawImage(whiteKnight, x, y, Constants.cellSize, Constants.cellSize, this);
                } else if (Bishop.isOccupiedBlack((x - xstart) / Constants.cellSize,
                        (y - ystart) / Constants.cellSize)){
                        g.drawImage(blackBishop, x, y, Constants.cellSize, Constants.cellSize, this);
                } else if (Bishop.isOccupiedWhite((x - xstart) / Constants.cellSize,
                        (y - ystart) / Constants.cellSize)){
                        g.drawImage(whiteBishop, x, y, Constants.cellSize, Constants.cellSize, this);
                }
            }
        }
    }
}
