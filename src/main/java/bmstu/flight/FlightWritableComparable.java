package bmstu.flight;


import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritableComparable implements WritableComparable {
    private int flag;
    private long dest_air_ip;

    public void write(DataOutput out) throws IOException {
        out.writeInt(flag);
        out.writeLong(dest_air_ip);
    }

    public void readFields(DataInput in) throws IOException {
        flag = in.readInt();
        dest_air_ip = in.readLong();
    }

    public void set_flag ( int flag){
        this.flag = flag;
    }

    public void  set_des_air ( int dest_air_ip){
        this.dest_air_ip = dest_air_ip;
    }

    public void

    public int compareTo(FlightWritableComparable o) {
        int thisValue = this.value;
        int thatValue = o.value;
        return (thisValue < thatValue ? -1 : (thisValue==thatValue ? 0 : 1));
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + counter;
        result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
        return result
    }
}