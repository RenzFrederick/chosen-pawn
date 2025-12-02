public class Square {
    public int positionx;
    public int positiony;

    public Square(int counter){
        this.positionx = counter/5;
        this.positiony = counter%5;
    }
}
