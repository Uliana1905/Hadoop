package ru.lab5;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;

public class storeActor {

    private HashMap <String,Integer> store =  new HashMap<>();

    @Override
    public AbstractActor.Receive createReceive(){
        return ReceiveBuilder.create()
                .match()
    }

}
