package springapplicationcontext.Event;

public class MyEvent {
    Object source;

    int data;

    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }
}
