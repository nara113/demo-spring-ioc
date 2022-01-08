package springapplicationcontext.Event;

import org.springframework.context.event.EventListener;
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
}
