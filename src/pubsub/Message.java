package pubsub;

import java.util.UUID;

/**
 * Created by Nikhil on 17-Jun-2022
 */
public class Message {
  private String message;
  private String id;

  /**
  *
  */
  public Message(String message) {
    this.message = message;
    id = UUID.randomUUID().toString();
  }

  public String getMessage() {
    return message;
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Message [message=" + message + ", id=" + id + "]";
  }

}
