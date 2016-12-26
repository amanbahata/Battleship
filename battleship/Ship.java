package battleship;

/**
 * Created by aman1 on 26/12/2016.
 */
public abstract class Ship {
    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal;
    boolean [] hit;

    public Ship(int length){
        this.length = length;
        this.hit = new boolean[length];
    }

    public int getBowRow(){
        return this.bowRow;
    }

    public int getBowColumn(){
        return this.bowColumn;
    }

    public boolean isHorizontal(){
        return this.horizontal;
    }
    public int getLength(){
        return this.length;
    }
}