package pubsub;

/**
 * Created by Nikhil on 18-Jun-2022
 */
public interface IPublisher {

  public boolean publish(Topic topic, Message message);

}
