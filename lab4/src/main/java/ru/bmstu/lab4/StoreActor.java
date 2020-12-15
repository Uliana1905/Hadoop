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
                /*.match(StoreMessage.class, m -> {
                    if (!store.containsKey(m.getPackageId())) {
                        store.put(m.getPackageId(), new HashMap<>());
                    }
                    store.get(m.getPackageId()).put(m.getTestName(), m.getResult());
                })*/
                .match(GetMessage.class, req -> {
                    ArrayList<String> results = new ArrayList<>();
                    results.add("hear you can see result\n");
                    store.put("1", results);
                    String id = req.getPackageId();
                    ArrayList<String> result = store.get(id);
                    getSender().tell(new StoreType (id, result), ActorRef.noSender());
                        }).build();

                        //new StoreType(req.getPackageId(), store.get(req.getPackageId())), self())
    }
}