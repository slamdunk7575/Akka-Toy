package me.toy.pingpong;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class PongActor extends UntypedAbstractActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private ActorRef ping;

    public PongActor(ActorRef ping) {
        this.ping = ping;
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {
            String msg = (String) message;
            log.info("Pong Received {}", msg);
            ping.tell("pong", getSelf());
            Thread.sleep(1000);
        }
    }
}
