package pubsub;

/**
 * Created by Nikhil on 17-Jun-2022
 */
public class MessageQueue {
  private Node front, rear;
  private int size, capacity;

  /**
   *
   */
  public MessageQueue(int capacity) {
    front = rear = null;
    this.capacity = capacity;
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean addToQueue(Message message) {
    if (size >= capacity) {
      return false;
    }

    Node temp = new Node(message);
    if (front == null) {
      front = temp;
    } else {
      rear.next = temp;
    }
    rear = temp;
    size++;
    return true;
  }

  public boolean removeMessage() {
    if (front == null) {
      return false;
    } else {
      front = front.next;
      size--;
      return true;
    }
  }

  public Message getMessage() {
    if (front == null) {
      return null;
    } else {
      return front.getMessage();
    }
  }

  public boolean addCapacity(int capacity) {
    this.capacity += capacity;
    return true;
  }

  @Override
  public String toString() {
    return "MessageQueue [front=" + front + ", rear=" + rear + ", size=" + size + ", capacity="
        + capacity + "]";
  }


}
