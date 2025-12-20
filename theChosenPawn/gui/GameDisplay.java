package gui;
import javax.swing.*;

import logic.Bishop;
import logic.Knight;
import logic.Pawn;
import logic.Piece;
import logic.Rook;

import java.io.IOException;

public class GameDisplay {

    protected static int hoveredy = -1;
    protected static int hoveredx = -1;
    protected static int selectedx = -1;
    protected static int selectedy = -1;
    protected static Piece pawn;
    protected static Piece rook;
    protected static Piece knight;
    protected static Piece bishop;

    public static JFrame frame = new JFrame("The Chosen Pawn") {
        {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(342, 683);
        }
    };

    public static int getSelectedX() {
        return selectedx;
    }

    public static int getSelectedY() {
        return selectedy;
    }

    public static void Start() throws IOException {
        // preparing all other classes to be used
        pawn = new Pawn();
        rook = new Rook();
        knight = new Knight();
        bishop = new Bishop();
        Promote.update(selectedx, selectedy);
        Pawn.startingBoard();

        // initializing components
        JLayeredPane panel = new JLayeredPane();
        JLabel turn = new TurnDisplay();
        JPanel grid = new BoardDisplay();
        JPanel pieces = new PieceDisplay();
        JPanel promoteButton = new Promote();
        GameMouseHandler handler = new GameMouseHandler(grid);

        // background gif
        ImageIcon backgroundIcon = new ImageIcon("theChosenPawn\\sprites\\background.gif");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // edit properties of grid component
        grid.addMouseMotionListener(handler);
        grid.addMouseListener(handler);
        grid.setBounds(0, 0, 342, 683);
        grid.setOpaque(false);

        // edit properties of pieces component
        pieces.setOpaque(false);
        pieces.setBounds(0, 0, 342, 683);

        // edit properties of turn component
        turn.setBounds(25, 25, 280, 140);

        // edit properties of promoteButton component
        promoteButton.setBounds(frame.getWidth() / 3, frame.getHeight() / 2 + frame.getHeight() / 6, 100, 300);
        promoteButton.setOpaque(false);

        // edit properties of panel component
        panel.add(backgroundLabel, Integer.valueOf(-1));
        panel.setLayout(null);
        panel.add(grid, Integer.valueOf(0));
        panel.add(pieces, Integer.valueOf(1));
        panel.add(turn, Integer.valueOf(2));
        panel.add(promoteButton, Integer.valueOf(3));

        // add panel component to frame and make visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
