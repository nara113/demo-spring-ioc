package springapplicationcontext.event;

import org.springframework.context.event.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

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

    @EventListener
    public void handler(RequestHandledEvent event) {
        System.out.println("HTTP 요청 처리했을 때 발생");
    }
}
