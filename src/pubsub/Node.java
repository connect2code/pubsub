package pubsub;

/**
 * Created by Nikhil on 17-Jun-2022
 */
public class Node {
  private Message message;

  public Message getMessage() {
    return message;
  }

  Node next;

  /**
   *
   */
  public Node(Message message) {
    this.message = message;
    next = null;
  }

  @Override
  public String toString() {
    return "Node [message=" + message + ", next=" + next + "]";
  }
}
