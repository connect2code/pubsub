package pubsub;

import java.util.Map;
import java.util.Set;

/**
 * Created by Nikhil on 18-Jun-2022
 */
public class Database {
  public static Map<Topic, Set<IConsumer>> subscriberMap;

  public static Map<IConsumer, MessageQueue> queueMap;

}
