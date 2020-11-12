package ru.bmstu.sparkLab;

import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Map;

public class FlightSerializable implements Serializable{
    private int arr_delay;
    private int cancelled;
    private int maxArr_delay;
    private int num_flight;
    private int num_cancelled;
    private int num_dellay;

   public FlightSerializable(int arr_delay, int cancelled){
        this.arr_delay = arr_delay;
        this.cancelled = cancelled;

    }
    public FlightSerializable(int maxArr_delay, int num_flight, int num_cancelled, int num_dellay){
       this.maxArr_delay =maxArr_delay;
       this.num_flight = num_flight;
       this.num_cancelled = num_cancelled;
       this.num_dellay = num_dellay;

    }

    public int getArr_delay_new () {
        return arr_delay;
    }

    public int getCancelled () {
        return cancelled;
    }

    public int getNum_flight (){
       return num_flight;
    }

    public int getNumCancelled() {
       return  num_cancelled;

    }

    public int getNum_dellay(){
       return num_dellay;
    }

    public static String combine (Tuple2<Integer,Integer> key, FlightSerializable value, Map<Integer,String> airportsBroadcasted ){

    }
}

