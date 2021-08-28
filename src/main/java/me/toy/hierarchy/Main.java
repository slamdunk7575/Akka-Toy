package me.toy.hierarchy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * AKKA 계층구조
 */
public class Main {

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("toySystem");
        ActorRef pingActor = actorSystem.actorOf(Props.create(PingActor.class), "pingActor");
        pingActor.tell("work", ActorRef.noSender());
    }

}
