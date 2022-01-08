package springapplicationcontext.aop;

import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @PerfLogging
    @Override
    public void createEvent() {
        System.out.println("create!");
    }

    @PerfLogging
    @Override
    public void publishEvent() {
        System.out.println("publish!");
    }

    @Override
    public void deleteEvent() {
        System.out.println("delete!");
    }
}
