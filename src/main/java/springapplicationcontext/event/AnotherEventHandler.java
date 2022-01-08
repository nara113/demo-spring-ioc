package springapplicationcontext.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherEventHandler {

    @EventListener
    @Async
    public void handler(MyEvent myEvent) {
        System.out.println(Thread.currentThread());
        System.out.println("Another : " + myEvent.data);
    }
}
