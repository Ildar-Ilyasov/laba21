import java.util.ArrayList;

public class Group {
    String name;
    ArrayList<Listener> subscribers;

    public Group(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    void subscribe(Listener subscriber) {
        subscribers.add(subscriber);
    }

    void unsubscribe(Listener subscriber) {
        subscribers.remove(subscriber);
    }

    void informUsers(String str) {
        for (Listener subscriber : subscribers) {
            subscriber.update(str);
        }
    }
}