package ru.bmstu.lab4;


import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExecutorActor extends AbstractActor {

    



    public String SolveTask (oneTest one_test) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(one_test.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(one_test.getFunctionName(), one_test.getParams().toArray()).toString();
    }

    public String CompareValue(oneTest one_test) throws  ScriptException, NoSuchMethodException{
        String myres = SolveTask(one_test);
        if (one_test.getExpectedResult().equals(myres)){
            return "functionName: " + one_test.getFunctionName() + "result = " + one_test.getExpectedResult() + ".True\n";
        }else{
            return "functionName: " + one_test.getFunctionName() + "result = " + one_test.getExpectedResult() + ".False" + " Correct result: " + myres;
        }
    }


    public Receive createReceive()
    {
        return ReceiveBuilder.create()
                .match (oneTest.class, task -> getSender().tell(
                        new StoreMessage(task.getPackageId(), CompareValue(task)), ActorRef.noSender())).
                        build();
    }


}
