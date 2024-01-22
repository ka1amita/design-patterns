package strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy {

  private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private CreditCard card;

  @Override
  public boolean pay(int paymentAmount) {
    if (cardIsPresent()) {
      System.out.printf("Paying %s using Credit Card.\n", paymentAmount);
      card.setAmount(card.getAmount() - paymentAmount);
      return true;
    } else {
      return false;
    }
  }

  private boolean cardIsPresent() {
    return card != null;
  }

  @Override
  public void collectPaymentDetails() {
    try {
      System.out.print("Enter the card number: ");
      String number = reader.readLine();
      System.out.print("Enter the card expiration date 'mm/yy': ");
      String date = reader.readLine();
      System.out.print("Enter the CVV code: ");
      String cvv = reader.readLine();
      card = new CreditCard(number, date, cvv);

      // Validate credit card number...

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private static class CreditCard {

    private final String number;
    private final String date;
    private final String cvv;
    private int amount;

    CreditCard(String number, String date, String cvv) {
      this.amount = 100_000;
      this.number = number;
      this.date = date;
      this.cvv = cvv;
    }

    public int getAmount() {
      return amount;
    }

    public void setAmount(int amount) {
      this.amount = amount;
    }
  }
}
