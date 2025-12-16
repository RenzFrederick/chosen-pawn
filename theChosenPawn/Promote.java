import javax.swing.*;

public class Promote extends JPanel {
    private static Piece pawn = new Pawn();
    private static Piece rook = new Rook();
    private static Piece bishop = new Bishop();
    private static Piece knight = new Knight();
    private static Promote instance;
    private static boolean blackPromoted;
    private static boolean whitePromoted;

    public Promote() {
        instance = this;
        instance.setVisible(false);
        blackPromoted = false;
        whitePromoted = false;

        JButton rookPromote = new JButton("Rook");
        JButton knightPromote = new JButton("Knight");
        JButton bishopPromote = new JButton("Bishop");
        this.add(rookPromote);
        this.add(knightPromote);
        this.add(bishopPromote);

        rookPromote.addActionListener(e -> {
            int x = GameDisplay.getSelectedX();
            int y = GameDisplay.getSelectedY();

            if ("White".equals(TurnOrder.getTurns()) && pawn.isOccupiedWhite(x, y)) {
                rook.promote(x, y);
                Moves.set(rook.loadMoves(x, y));
                whitePromoted = true;
            } else if ("Black".equals(TurnOrder.getTurns()) && pawn.isOccupiedBlack(x, y)) {
                rook.promote(x, y);
                Moves.set(rook.loadMoves(x, y));
                blackPromoted = true;
            }

            System.out.println("Promote button clicked at current position: " + x + ", " + y);
        });

        bishopPromote.addActionListener(e -> {
            int x = GameDisplay.getSelectedX();
            int y = GameDisplay.getSelectedY();

            if ("White".equals(TurnOrder.getTurns()) && pawn.isOccupiedWhite(x, y)) {
                bishop.promote(x, y);
                Moves.set(bishop.loadMoves(x, y));
                whitePromoted = true;
            } else if ("Black".equals(TurnOrder.getTurns()) && pawn.isOccupiedBlack(x, y)) {
                bishop.promote(x, y);
                Moves.set(bishop.loadMoves(x, y));
                blackPromoted = true;
            }

            System.out.println("Promote button clicked at current position: " + x + ", " + y);
        });

        knightPromote.addActionListener(e -> {
            int x = GameDisplay.getSelectedX();
            int y = GameDisplay.getSelectedY();

            if ("White".equals(TurnOrder.getTurns()) && pawn.isOccupiedWhite(x, y)) {
                knight.promote(x, y);
                Moves.set(knight.loadMoves(x, y));
                whitePromoted = true;
            } else if ("Black".equals(TurnOrder.getTurns()) && pawn.isOccupiedBlack(x, y)) {
                knight.promote(x, y);
                Moves.set(knight.loadMoves(x, y));
                blackPromoted = true;
            }

            System.out.println("Promote button clicked at current position: " + x + ", " + y);
        });
    }

    public static void update(int x, int y){
        if (instance == null) return;

            if ((pawn.isOccupiedWhite(x, y) && (whitePromoted != true)&& TurnOrder.getTurns() == "White") 
                || (pawn.isOccupiedBlack(x, y) && (blackPromoted != true) && TurnOrder.getTurns() == "Black")) {
                instance.setVisible(true);
            } else {
                instance.setVisible(false);
            }
    }
}