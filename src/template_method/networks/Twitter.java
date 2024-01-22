package template_method.networks;

public class Twitter extends Network {

  public Twitter(String userName, String password) {
    super(userName, password);
  }

  @Override
  protected boolean logIn(String userName, String password) {
    System.out.println("\nChecking user's parameters");
    System.out.println("Name: " + this.userName);
    System.out.print("Password: ");
    for (int i = 0; i < this.password.length(); i++) {
      System.out.print("*");
    }
    simulateNetworkLatency();
    System.out.println("\n\nLogIn success on Twitter\n");
    return true;
  }

  private void simulateNetworkLatency() {
    try {
      int i = 0;
      System.out.println();
      while (i < 10) {
        System.out.print(".");
        Thread.sleep(500);
        i++;
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  protected boolean sendData(byte[] data) {
    System.out.printf("Message: '%s' was posted on Twitter\n", new String(data));
    return true;
  }

  @Override
  public void logOut() {
    System.out.printf("User: '%s' was logged out from Twitter\n", userName);
  }
}
