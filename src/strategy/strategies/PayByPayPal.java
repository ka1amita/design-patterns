package strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByPayPal implements PayStrategy {

  private static final Map<String, String> DATABASE = new HashMap<>();

  static {
    DATABASE.put("amanda1985", "amanda@ya.com");
    DATABASE.put("qwerty", "john@amazon.eu");
  }

  private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private String email;
  private String password;
  private boolean signedIn;

  @Override
  public void collectPaymentDetails() {
    try {
      while (!signedIn) {
        System.out.print("Enter the user's email: ");
        email = reader.readLine();
        System.out.print("Enter the password: ");
        password = reader.readLine();
        if (verify()) {
          signIn();
          System.out.println("Data verification has been successful.");
        } else {
          signOut();
          System.out.println("Wrong email or password!");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private boolean verify() {
    return email.equals(DATABASE.get(password));
  }

  private void signIn() {
    this.signedIn = true;
  }

  private void signOut() {
    this.signedIn = false;
  }

  @Override
  public boolean pay(int paymentAmount) {
    if (signedIn) {
      System.out.printf("Paying %s using PayPal\n", paymentAmount);
      return true;
    } else {
      return false;
    }
  }
}
