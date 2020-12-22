package ru.lab5;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;


import java.util.HashMap;

public class storeActor extends AbstractActor{

    private HashMap <String,Integer> store =  new HashMap<>();

    @Override
    public AbstractActor.Receive createReceive(){
        return ReceiveBuilder.create()
                .match(SentActorMsg.class, req ->{
                    String url = req.getUrl();
                    Integer result = store.get (url);
                    if (result!=null){
                        getSender().tell(result, ActorRef.noSender());
                    }else {
                        getSender().tell(0, ActorRef.noSender());
                    }
                })
    }

}
