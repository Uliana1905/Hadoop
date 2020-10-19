package bmstu.flight;


import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritableComparable implements WritableComparable<FlightWritableComparable>{
    private int flag;
    private int dest_air_id;

    public void write(DataOutput out) throws IOException {
        out.writeInt(flag);
        out.writeLong(dest_air_id);
    }
    public FlightWritableComparable() {
    }

    public FlightWritableComparable(int flag, int dest_air_id) {
        super();
        this.flag = flag;
        this.dest_air_id = dest_air_id;
    }

    public void readFields(DataInput in) throws IOException {
        flag = in.readInt();
        dest_air_id = in.readInt();
    }


    public int getDes_air (){
        return dest_air_id;
    }

    public int getFlag() {
        return flag;
    }

    public int hashCode() {
        return this.getDes_air();
    }

    @Override
    public int compareTo(FlightWritableComparable o) {
        FlightWritableComparable that =  o;

        int that_flag = that.getFlag();
        int that_dest_air_id = that.getDes_air();

        if (this.dest_air_id > that_dest_air_id){
            return 1;
        }
        if (this.dest_air_id < that_dest_air_id){
            return -1;
        }

        if (this.flag > that_flag){
            return 1;
        }
        if (this.flag < that_flag){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "[" + dest_air_id + " " + flag + "]";
    }
}