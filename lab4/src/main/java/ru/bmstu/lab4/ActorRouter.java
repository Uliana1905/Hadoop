package ru.bmstu.lab4;
import akka.actor.*;
import akka.japi.pf.DeciderBuilder;
import akka.routing.RoundRobinPool;
import akka.stream.ActorAttributes;

import java.time.Duration;

import static akka.actor.SupervisorStrategy.restart;

public class ActorRouter extends AbstractActor{

    private final ActorRef Executors = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ExecuteActor,class)));
    private final ActorRef storActor = getContext().actorOf(Props.create(StoreActor.class));
    private static ActorAttributes.SupervisionStrategy strategy =
            new OneForOneStrategy(10, Duration.ofSeconds(10), DeciderBuilder.matchAny(o -> restart()).build());

    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

}

