package bmstu.flight;


import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritableComparable implements WritableComparable{
    private int flag;
    private int dest_air_id;

    public void write(DataOutput out) throws IOException {
        out.writeInt(flag);
        out.writeLong(dest_air_id);
    }

    public void readFields(DataInput in) throws IOException {
        flag = in.readInt();
        dest_air_id = in.readInt();
    }

    public void set_flag ( int flag){
        this.flag = flag;
    }

    public void  set_des_air ( int dest_air_ip){
        this.dest_air_id = dest_air_ip;
    }

    public int getDes_air (){
        return dest_air_id;
    }


   // public int hashCode() {
      //  final int prime = 31;
      //  int result = 1;
      //  result = prime * result + counter;
      //  result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
      //  return result
    //}

    @Override
    public int compareTo(Object o) {
        FlightWritableComparable that = (FlightWritableComparable) o;

        int that_flag = that.flag;
        int that_dest_air_id = that.dest_air_id;

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
}