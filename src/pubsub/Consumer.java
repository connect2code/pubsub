package pubsub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 18-Jun-2022
 */
public class Consumer implements IConsumer {

  private String name;
  private IPubSubSystem pubSubSystem;
  private List<Message> messages;


  /**
   *
   */
  public Consumer(IPubSubSystem pubSubSystem, String name) {
    this.pubSubSystem = pubSubSystem;
    this.name = name;
    messages = new ArrayList<>();
  }

  @Override
  public void getMessages() {
    messages = pubSubSystem.getMessages(this);
  }

  @Override
  public void printMessages() {
    for (Message message : messages) {
      System.out.println(name + " " + message.getMessage());
    }
  }

  @Override
  public String toString() {
    return "Consumer [name=" + name + ", pubSubSystem=" + pubSubSystem + ", messages=" + messages
        + "]";
  }


}
