package ru.bmstu.sparkLab;

import java.io.Serializable;

public class FlightSerializable implements Serializable{
    private int orig_air_id;
    private int dest_air_id;
    private int arr_delay_new;
    private int concelled;
   public void FlightSerializable(int orig_air_id, int dest_air_id, int arr_delay_new, int concelled){

        this.orig_air_id = orig_air_id;
        this.dest_air_id = dest_air_id;
        this.arr_delay_new = arr_delay_new;
        this.concelled = concelled;

    }

    public int getOrig_air_id () {
        return orig_air_id;
    }

    public int getDest_air_id () {
        return dest_air_id;
    }

    public int getArr_delay_new () {
        return arr_delay_new;
    }

    public int getConcelled () {
        return concelled;
    }
}
