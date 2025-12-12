import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TurnDisplay extends JLabel{

    private static final String black_image = "theChosenPawn\\sprites\\blackTurn.png";
    private static final String white_image = "theChosenPawn\\sprites\\whiteTurn.png";

    private static ImageIcon blackIcon;
    private static ImageIcon whiteIcon;

    private static TurnDisplay instance;

    public TurnDisplay() {
        super();
        instance = this;
        if (blackIcon == null || whiteIcon == null) {
            blackIcon = loadScaledIcon(black_image, 150, 75);
            whiteIcon = loadScaledIcon(white_image, 150, 75);
        }
        updateTurn();
    }

    private static ImageIcon loadScaledIcon(String path, int w, int h) {
        ImageIcon orig = new ImageIcon(path);
        Image img = orig.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public static void updateTurn(){
        String t = TurnOrder.getTurns();
        if (t == "Black") {
            instance.setIcon(blackIcon);
        } else if (t == "White") {
            instance.setIcon(whiteIcon);
        } else {
            instance.setIcon(null);
            instance.setText("Turn: " + t);
        }
        instance.repaint();
    }
}
