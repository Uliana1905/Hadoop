package ru.bmstu.lab4;
import akka.actor.*;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;

public class ActorRouter extends AbstractActor{

    private final ActorRef executors = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ExecutorActor.class)));
    private final ActorRef storActor = getContext().actorOf(Props.create(StoreActor.class));
   // private static ActorAttributes.SupervisionStrategy strategy =
      ///      new OneForOneStrategy(10, Duration.ofSeconds(10), DeciderBuilder.matchAny(o -> restart()).build());

   // public SupervisorStrategy supervisorStrategy() {
      //  return strategy;
   // }

    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(StoreMessage.class, msg -> executors.tell(msg, ActorRef.noSender()))
                
                .match(MessageResult.class, msg -> storActor.tell ( msg, sender())).build();
    }
}

