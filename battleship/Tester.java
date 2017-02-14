package battleship;

/**
 * Created by aman1 on 13/02/2017.
 */
public class Tester {
    public static void main(String [] args){
        Ocean a = new Ocean();
        a.placeAllShipsRandomly();
        System.out.println();
        System.out.println("==============================");
        System.out.println();

        Ship[][] shipArray = a.getShipArray();

        for (int i=0;i< shipArray.length; i++){
            for (int j=0;j<shipArray[i].length; j++){
                System.out.printf("|   %-10s  " , shipArray[i][j].getShipType());
            }
            System.out.println("");
            System.out.println("");
        }

    }
}
