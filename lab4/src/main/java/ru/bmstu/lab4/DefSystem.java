package ru.bmstu.lab4;



import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import scala.concurrent.Future;


import java.io.IOException;
import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;




public class DefSystem {
    public static void main( String []args) throws IOException {

        private final static String HOST = "localhost";

        private 


        ActorSystem system = ActorSystem.create("lab4");
        ActorRef actorRouter = system.actorOf(Props.create(ActorRouter.class ));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        DefSystem instance = new DefSystem();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                instance.createRoute(actorRouter).flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost(HOST, 8080),
                materializer);
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        binding.thenCompose(ServerBinding::unbind).thenAccept(unbound -> system.terminate());

    }

    private Route createRoute(ActorRef actorRouter) {
        return route(
                get(
                        () -> parameter("packageId",
                                (id) -> {
                                    Future<Object> f = Patterns.ask(actorRouter, new MessageResult(id), 100);
                                    return completeOKWithFuture(f, Jackson.marshaller());
                                })
                ),
                post(
                        () -> entity(Jackson.unmarshaller(ReceiveJSON.class),
                                (requestBody) -> {
                            actorRouter.tell(requestBody, ActorRef.noSender());
                            return complete("I'm done");
                                })
                )
        );
    }
}



