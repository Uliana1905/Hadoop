package ru.lab5;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;


import java.util.HashMap;

public class storeActor extends AbstractActor{
    private final static Integer MSG_NOT_IN_STORE = 0;

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
                        getSender().tell(MSG_NOT_IN_STORE, ActorRef.noSender());
                    }
                })
                .match(StoreResults.class, req ->{
                    store.put(req.getUrl(), req.getResult());
                }).build();
    }

}
