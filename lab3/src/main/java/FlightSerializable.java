import java.io.Serializable;

public class FlightSerializable extends Serializable<>{
    private int orig_air_id;
    private int dest_air_id;
    private int arr_delay_new;
    private int concelled;
    @Override
   public void FlightSerializable(int orig_air_id, int dest_air_id, int arr_delay_new, int concelled){

        this.orig_air_id = orig_air_id;
        this.dest_air_id = dest_air_id;
        this.arr_delay_new = arr_delay_new;
        this.concelled = concelled;

    }

    
}
