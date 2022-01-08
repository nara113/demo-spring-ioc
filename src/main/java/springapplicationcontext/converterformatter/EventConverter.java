package springapplicationcontext.converterformatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import springapplicationcontext.propertyeditor.Event;

public class EventConverter {
    @Component
    public static class stringToEventConverter implements Converter<String, Event> {
        @Override
        public Event convert(String source) {
            return new Event(Integer.parseInt(source));
        }
    }

    @Component
    public static class EventToStringConverter implements Converter<Event, String> {
        @Override
        public String convert(Event source) {
            return source.getId().toString();
        }
    }
}
