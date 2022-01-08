package springapplicationcontext.Event;

import org.springframework.context.event.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    @Async
//    @Order(Ordered.HIGHEST_PRECEDENCE + 2)
    public void handler(MyEvent myEvent) {
        System.out.println(Thread.currentThread());
        System.out.println("myEvent : " + myEvent.data);
    }

    @EventListener
    public void handler(ContextRefreshedEvent event) {
        System.out.println("Refreshed! " + Thread.currentThread());
    }

    @EventListener
    public void handler(ContextStartedEvent event) {
        System.out.println("Started! " + Thread.currentThread());
    }

    @EventListener
    public void handler(ContextStoppedEvent event) {
        System.out.println("Stopped! " + Thread.currentThread());
    }

    @EventListener
    public void handler(ContextClosedEvent event) {
        System.out.println("closed! " + Thread.currentThread());
    }
}
