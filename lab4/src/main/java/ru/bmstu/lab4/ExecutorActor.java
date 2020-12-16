package ru.bmstu.lab4;


import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutorActor extends AbstractActor {




    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    engine.eval(jscript);
    Invocable invocable = (Invocable) engine;
    return invocable.invokeFunction(functionName, params).toString();

    public Receive createReceive()
    {
        return null;
    }


}
