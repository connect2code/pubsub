package pubsub;

/**
 * Created by Nikhil on 17-Jun-2022
 */
public class Topic {
  private String name;

  /**
   *
   */
  public Topic(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Topic [name=" + name + "]";
  }



}
