package ru.bmstu.lab4;




import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class DefSystem {
    public static void
    main( String []args) throws IOException {
        ActorSystem system = ActorSystem.create("lab4");
        ActorRef store_actor = system.actorOf(Props.create(StoreActor.class), "storeActor")
        ActorRef execute_actor = system.actorOf(Props.create(ExecuteActor.class), "executeActor"
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        MainHttp instance = new MainHttp(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                instance.createRoute(system).flow(system, materializer);
        final CompletionStage<Tcp.ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8080),
                materializer
        );
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }


}
