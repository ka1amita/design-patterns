package singleton;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SingletonTest {

  @Test
  void testNewSingleton() {
    Singleton s = Singleton.newSingleton("message");
    Singleton s1 = Singleton.newSingleton("message1");
    assertEquals(s, s1);
  }
}
