package observer.example;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

  private final Map<String, List<EventListener>> listeners;

  public EventManager(String... operations) {
    listeners = new HashMap<>();
    for (String operation : operations) {
      listeners.put(operation, new ArrayList<>());
    }
  }

  public void subscribe(String eventType, EventListener listener) {
    listeners.get(eventType).add(listener);
  }

  public void unsubscribe(String eventType, EventListener listener) {
    listeners.get(eventType).remove(listener);
  }

  public void notify(String eventType, File file) {
    for (EventListener listener : listeners.get(eventType)) {
      listener.update(eventType, file);
    }
  }
}
