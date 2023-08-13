package singleton;

public class Singleton {

  private static Singleton singleton;
  private String message;

  /**
   * both constructors made private to prevent it from being called upon
   */
  private Singleton() {
  }

  private Singleton(String message) {
    this.message = message;
  }

  /**
   * public static
   */
  public static Singleton newSingleton(String message) {
    if (singleton == null) {
      singleton = new Singleton(message);
      return singleton;
    } else {
      singleton.message = message;
      return singleton;
    }
  }

  @Override
  public String toString() {
    return message;
  }
}
