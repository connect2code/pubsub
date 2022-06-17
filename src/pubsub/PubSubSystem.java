package pubsub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Nikhil on 17-Jun-2022
 */
public class PubSubSystem implements IPubSubSystem {


  private int queueCapacity;

  /**
   *
   */
  public PubSubSystem(int queueCapacity) {
    this.queueCapacity = queueCapacity;
    Database.subscriberMap = new HashMap<>();
    Database.queueMap = new HashMap<>();
  }


  @Override
  public boolean addSubscriber(Topic topic, IConsumer consumer) {
    Set<IConsumer> consumers = null;
    if (Database.subscriberMap.containsKey(topic)) {
      consumers = Database.subscriberMap.get(topic);
      consumers.add(consumer);
    } else {
      consumers = new HashSet<>();
      consumers.add(consumer);
      Database.subscriberMap.put(topic, consumers);
    }
    Database.subscriberMap.put(topic, consumers);
    return true;
  }

  @Override
  public boolean publishMesssage(Topic topic, Message message) {
    if (!Database.subscriberMap.containsKey(topic)) {
      return false;
    }
    Set<IConsumer> consumers = Database.subscriberMap.get(topic);
    for (IConsumer consumer : consumers) {
      if (Database.queueMap.containsKey(consumer)) {
        MessageQueue queue = Database.queueMap.get(consumer);
        queue.addToQueue(message);
        Database.queueMap.put(consumer, queue);
      } else {
        MessageQueue queue = new MessageQueue(queueCapacity);
        queue.addToQueue(message);
        Database.queueMap.put(consumer, queue);
      }
    }
    return true;
  }

  @Override
  public List<Message> getMessages(IConsumer consumer) {

    if (!Database.queueMap.containsKey(consumer)) {
      return new ArrayList<>();
    }


    MessageQueue queue = Database.queueMap.get(consumer);
    if (queue == null) {
      return new ArrayList<>();
    }

    List<Message> messages = new ArrayList<>();
    while (!queue.isEmpty()) {
      Message message = queue.getMessage();
      messages.add(message);
      queue.removeMessage();
    }
    return messages;
  }

  @Override
  public boolean removeSubscriber(Topic topic, IConsumer consumer) {
    if (Database.subscriberMap.containsKey(topic)) {
      Set<IConsumer> consumers = Database.subscriberMap.get(topic);
      consumers.remove(consumer);
      Database.subscriberMap.put(topic, consumers);
      return true;
    }
    return false;
  }


  @Override
  public String toString() {
    return "PubSubSystem [subscriberMap=" + Database.subscriberMap + ", queueMap="
        + Database.queueMap + ", queueCapacity=" + queueCapacity + "]";
  }


}
