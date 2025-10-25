import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
  Scanner scanner;
  String name;
  double balance;
  ArrayList<Product> cart;

  public Customer (String name, double balance, Scanner scanner) {
    this.name = name;
    this.balance = balance;
    this.scanner = scanner;
  }

  public double addToCart(ArrayList<Product> cart, ArrayList<Product> products) {
    System.out.println("Available Products:");
    for (int i = 0; i < products.size(); i++) {
      System.out.println((i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice() + "₺");
    }

    System.out.print("Enter the number of the item you want to add: ");
    int choice = scanner.nextInt();

    if (choice > 0 && choice <= products.size()) {
      Product selected = products.get(choice - 1);
      cart.add(selected);
      System.out.println(selected.getName() + " successfully added to cart!");
    } else {
      System.out.println("Choice is invalid!");
    }

    double total = 0;
    for (Product p : cart) {
      total += p.getPrice();
    }

    return total;
  }

  public void showCost (ArrayList<Product> cart) {
    double total = 0;

    for (Product product : cart) {
      total += product.getPrice();
    }
    System.out.println(total);
  }

  public double costPay(double total) {
    if (total > this.balance) {
      System.out.println("You cannot afford " + total + "please come back later! ");
      return -1;
    }
    else {
      this.balance -= total;
      return this.balance;
    }
  }
}
