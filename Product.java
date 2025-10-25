import java.util.Scanner;

public class Product {
  Scanner scanner;
  private String name;
  private double price;
  private int stock;

  public Product(String name, double price, int stock, Scanner scanner) {
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.scanner = scanner;
  }

  public void setStock() {
    this.stock = stock;
  }

  public int getStock() {
    return this.stock;
  }

  public void setPrice() {
    this.price = price;
  }

  public double getPrice() {
    return this.price;
  }

  public void setName() {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void updateStock() {
    System.out.print("How many items sold today? ");
    int sold = scanner.nextInt();

    if (sold > stock) {
      System.out.println("Cannot sell more than available stock!");
      sold = 0;
    }

    stock -= sold;

    System.out.print("How many items added to stock today? ");
    int added = scanner.nextInt();

    if (added < 0) {
      System.out.println("Cannot add negative stock!");
      added = 0;
    }

    stock += added;

    System.out.println("Updated stock for " + name + ": " + stock);
  }


  public void showInfo() {
    System.out.println("Name: " + this.name + " Price: " + this.price + " Stock: " +this.stock);
  }

  @Override
  public String toString() {
    return name + " - " + price + "₺";
  }

}
