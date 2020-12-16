package ru.bmstu.lab4;


import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExecutorActor extends AbstractActor {

    private final static String STR_FUNCTION_NAME = "functionName: ";

    private final static String STR_RESULT = "result = ";
    private final static String STR_TRUE = ".True";
    private final static String STR_FALSE = ".False";
    private final static String STR_CORRECT_RESULT = " Correct result: ";
    private final static String SHORTNAME = "nashorn";

    public String SolveTask (oneTest one_test) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(SHORTNAME);
        engine.eval(one_test.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(one_test.getFunctionName(), one_test.getParams().toArray()).toString();
    }

    public String CompareValue(oneTest one_test) throws  ScriptException, NoSuchMethodException{
        String myres = SolveTask(one_test);
        if (one_test.getExpectedResult().equals(myres)){
            return STR_FUNCTION_NAME + one_test.getFunctionName() + STR_RESULT + one_test.getExpectedResult() + STR_TRUE;
        }else{
            return STR_FUNCTION_NAME + one_test.getFunctionName() + STR_RESULT + one_test.getExpectedResult() + STR_FALSE + STR_CORRECT_RESULT + myres;
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
