package me.toy.hierarchy;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Ping3Actor extends UntypedAbstractActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            String msg = (String)message;
            if ("work".equals(msg)) {
                log.info("Ping3 received {}", msg);
                work();
                getSender().tell("done", getSelf());
            }
        }
    }

    private void work() throws Exception {
        Thread.sleep(1000); // 실전에서는 절대 금물!!!
        log.info("Ping3 working...");
    }
}
