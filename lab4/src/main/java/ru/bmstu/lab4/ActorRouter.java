package ru.bmstu.lab4;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ActorRouter extends AbstractActor{

    private final ActorRef Executors = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ExecuteActor,class)));
    private final ActorRef storActor = get ().actorOf(Props.create(StoreActor.class));
}
