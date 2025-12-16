public class TurnOrder {
    private static int turns;

    public TurnOrder() {
        turns = 0;
    }

    public static void nextTurn() {
        turns += 1;
        if (Board.noMoreMoves(getTurns()) || Board.noPiecesLeft(getTurns())) {
            System.out.println("Game Over! " + getTurns() + " has no more moves or pieces left.");
            System.exit(0);
        }
        
    }

    public static String getTurns() {
        if (turns % 2 == 0) {
            return "White";
        } else if (turns % 2 == 1) {
            return "Black";
        } else {
            return "Error";
        }
    }
}
