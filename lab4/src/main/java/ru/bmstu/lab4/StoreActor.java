package ru.bmstu.lab4;


import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreActor extends AbstractActor {
    private HashMap<String, ArrayList<String>> store = new HashMap<>();
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(StoreMessage.class, m -> {
                    if (!store.containsKey(m.getPackageId())) {
                        store.put(m.getPackageId(), new ArrayList<>());
                    }
                    store.get(m.getPackageId()).add(m.getResult());

                }).build();
                .match(MessageResult.class, req -> {
                    getSender().tell(new GetMessage(req.getPackageId(), store.get(req.getPackageId())), ActorRef.noSender());
                        });

    }
}