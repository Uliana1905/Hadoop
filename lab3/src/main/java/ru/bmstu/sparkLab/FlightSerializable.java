package ru.bmstu.sparkLab;

import java.io.Serializable;

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

    public int getConcelled () {
        return cancelled;
    }

    public int getNum_flight (){
       return num_flight;
    }

}
