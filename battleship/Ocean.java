package battleship;

/**
 * Created by aman1 on 15/01/2017.
 */
public class Ocean {
    private Ship [][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ocean(){
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
        this.ships = new Ship[10][10];
        fillShipsArrayWithEmptySeas(this.ships);
    }

    public void fillShipsArrayWithEmptySeas(Ship[][] ships){
        for (int i=0; i<ships[i].length; i++){
            for (int j=0; j<ships[i].length; j++){
                ships[i][j] = new EmptySea();
            }
        }

    }

}
