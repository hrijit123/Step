import java.util.*;

public class parking_lot {

    String[] spots=new String[50];

    int hash(String plate){
        return Math.abs(plate.hashCode())%spots.length;
    }

    public void park(String plate){

        int i=hash(plate);

        while(spots[i]!=null)
            i=(i+1)%spots.length;

        spots[i]=plate;

        System.out.println("Parked at "+i);
    }

    public static void main(String[] args){

        parking_lot p=new parking_lot();

        p.park("ABC123");
        p.park("XYZ999");
    }
}