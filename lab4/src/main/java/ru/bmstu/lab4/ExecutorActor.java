package ru.bmstu.lab4;


import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutorActor extends AbstractActor {



    public String SolveTask (oneTest one_test) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(one_test.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(one_test.getFunctionName(), one_test.getParams().toArray()).toString();
    }

    public Receive createReceive()
    {
        return ReceiveBuilder.create()
                .match (oneTest.class, task -> getSender().tell(
                        new StoreMessage(task.getPackageId(), SolveTask(task)), ActorRef.noSender())).
                        build();
    }


}
