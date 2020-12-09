package ru.bmstu.lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;


public class DefSystem {
    public static void main( String []args) throws IOException {
        ActorSystem system = ActorSystem.create("lab4");
        ActorRef store_actor = system.actorOf(Props.create(StoreActor.class), "storeActor")
        ActorRef execute_actor = system.actorOf(Props.create(ExecuteActor.class), "executeActor"
        
    }


}
