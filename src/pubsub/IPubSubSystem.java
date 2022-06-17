package pubsub;

import java.util.List;

/**
 * Created by Nikhil on 17-Jun-2022
 */
public interface IPubSubSystem {
  public boolean addSubscriber(Topic topic, IConsumer consumer);

  public boolean removeSubscriber(Topic topic, IConsumer consumer);

  public boolean publishMesssage(Topic topic, Message message);

  public List<Message> getMessages(IConsumer consumer);
}
