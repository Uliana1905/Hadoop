package ru.bmstu.sparkLab;

import java.io.Serializable;

public class FlightSerializable implements Serializable{
    private int arr_delay_new;
    private int cancelled;

   public FlightSerializable(int arr_delay_new, int concelled){
        this.arr_delay_new = arr_delay_new;
        this.cancelled = concelled;

    }

    public int getArr_delay_new () {
        return arr_delay_new;
    }

    public int getConcelled () {
        return cancelled;
    }
}
