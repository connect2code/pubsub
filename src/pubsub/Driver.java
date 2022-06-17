package pubsub;

/**
 * Created by Nikhil on 18-Jun-2022
 */
public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    IPubSubSystem pubSubSystem = new PubSubSystem(3);
    IPublisher publisher = new Publisher(pubSubSystem);
    Topic topic1 = new Topic("1");
    Topic topic2 = new Topic("2");
    IConsumer consumer1 = new Consumer(pubSubSystem, "consumer1");
    IConsumer consumer2 = new Consumer(pubSubSystem, "consumer2");



    pubSubSystem.addSubscriber(topic1, consumer1);
    pubSubSystem.addSubscriber(topic1, consumer2);
    pubSubSystem.addSubscriber(topic2, consumer2);

    publisher.publish(topic1, new Message("topic1 message1"));
    publisher.publish(topic1, new Message("topic1 message2"));
    publisher.publish(topic2, new Message("topic2 message1"));


    consumer1.getMessages();
    consumer1.printMessages();

    consumer2.getMessages();
    consumer2.printMessages();

  }

}
