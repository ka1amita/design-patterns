package template_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import template_method.networks.Facebook;
import template_method.networks.Network;
import template_method.networks.Twitter;

public class Demo {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Input user name: ");
    String userName = reader.readLine();
    System.out.print("Input password: ");
    String password = reader.readLine();

    // Enter the message.
    System.out.print("Input message: ");
    String message = reader.readLine();

    System.out.println("Choose social network for posting message.\n" +
                           "1 - Facebook\n" +
                           "2 - Twitter");
    int choice = Integer.parseInt(reader.readLine());
    Network network = null;
    switch (choice) {
      case 1:
        network = new Facebook(userName, password);
        break;
      case 2:
        network = new Twitter(userName, password);
        break;
    }

    network.post(message);
  }
}
