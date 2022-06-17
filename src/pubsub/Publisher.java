package pubsub;

/**
 * Created by Nikhil on 18-Jun-2022
 */
public class Publisher implements IPublisher {
  IPubSubSystem pubSubSystem;

  /**
   *
   */
  public Publisher(IPubSubSystem pubSubSystem) {
    this.pubSubSystem = pubSubSystem;
  }

  @Override
  public boolean publish(Topic topic, Message message) {
    pubSubSystem.publishMesssage(topic, message);
    return false;
  }

  @Override
  public String toString() {
    return "Publisher [pubSubSystem=" + pubSubSystem + "]";
  }

}
