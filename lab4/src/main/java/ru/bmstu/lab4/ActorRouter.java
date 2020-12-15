package ru.bmstu.lab4;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.routing.RoundRobinPool;
import akka.stream.ActorAttributes;

public class ActorRouter extends AbstractActor{

    private final ActorRef Executors = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ExecuteActor,class)));
    private final ActorRef storActor = getContext().actorOf(Props.create(StoreActor.class));
    private static ActorAttributes.SupervisionStrategy strategy =
            new OneForOneStrategy(10,Duraction.ofSeconds(10))

}

