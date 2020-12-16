package ru.bmstu.lab4;


import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutorActor extends AbstractActor {




    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    engine.eval(one_test.geJsSctipt);
    Invocable invocable = (Invocable) engine;
    return invocable.invokeFunction(one_test.getfunctionName(), one_test.getParams).toString();

    public Receive createReceive()
    {
        return ReceiveBuilder.create()
                .match (oneTest.class, task -> getSender().tell(
                        
                ))
    }


}
