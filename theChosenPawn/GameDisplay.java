import javax.swing.*;
import java.io.IOException;
public class GameDisplay {

    // instantiate JFrame
    public static JFrame frame = new JFrame("The Chosen Pawn");
    protected static int hoveredy = -1;
    protected static int hoveredx = -1;
    protected static int selectedx = -1;
    protected static int selectedy = -1;
    protected static Piece pawn;
    protected static Piece rook;
    protected static Piece knight;
    protected static Piece bishop;

    public static int getSelectedX() {
        return selectedx;
    }

    public static int getSelectedY() {
        return selectedy;
    }

    public static void Start() throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(342, 683);
        pawn = new Pawn();
        rook = new Rook();
        knight = new Knight();
        bishop = new Bishop();
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

        GameMouseHandler handler = new GameMouseHandler(grid);
        grid.addMouseMotionListener(handler);
        grid.addMouseListener(handler);

        JPanel pieces = new PieceDisplay();
        JPanel promoteButton = new Promote();

        grid.setOpaque(false); // let background image show through
        pieces.setOpaque(false);

        grid.setBounds(0, 0, 342, 683);
        pieces.setBounds(0, 0, 342, 683);
        turn.setBounds(25, 25, 280, 140);
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
