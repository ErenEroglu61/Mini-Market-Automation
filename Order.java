import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
  Customer customer;
  ArrayList<Product> items;
  double totalPrice;
  LocalDate orderDate;

  public Order(Customer customer, ArrayList<Product> items, double totalPrice, LocalDate orderDate){
    this.customer = customer;
    this.items = items;
    this.totalPrice = totalPrice;
    this.orderDate = orderDate;
  }

  public void showOrderDetails() {
    System.out.println("Price: " + this.totalPrice + " Customer info: " + this.customer.name + " Date: " + this.orderDate + " ");
  }

  public void getCustomerName() {
    System.out.println(this.customer.name);
  }

  public void getItems() {
    System.out.println(this.items);
  }

  public void getTotalPrice() {
    System.out.println(this.totalPrice);
  }

  public void getOrderDate() {
    System.out.println(this.orderDate);
  }
}
