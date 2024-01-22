package strategy.order;

import strategy.strategies.PayStrategy;

public class Order {

  private PayStrategy strategy;

  private boolean closed;

  private int totalCost = 0;

  public void setStrategy(PayStrategy strategy) {
    this.strategy = strategy;
  }


  public int getTotalCost() {
    return totalCost;
  }

  public void addToTotalCost(int cost) {
    this.totalCost += cost;
  }

  public void close() {
    this.closed = true;
  }

  public boolean isClosed() {
    return closed;
  }

  public void processOrder(PayStrategy strategy) {
    this.strategy = strategy;
    strategy.collectPaymentDetails();
  }
}
