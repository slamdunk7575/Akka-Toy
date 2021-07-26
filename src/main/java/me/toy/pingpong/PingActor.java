package me.toy.pingpong;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class PingActor extends UntypedAbstractActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private ActorRef pong;

    @Override
    public void preStart() {
        this.pong = context().actorOf(Props.create(PongActor.class, getSelf()), "pongActor");
    }

    @Override
    public void onReceive(Object message) {
        if (message instanceof String) {
            String msg = (String) message;
            log.info("Ping received {}", msg);
            pong.tell("ping", getSelf());
        }
    }
}
