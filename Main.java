import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Product bread = new Product("Bread",2.5, 10000, scanner);
    Product cheese = new Product("Cheese", 12.0, 12000, scanner);
    Product oil = new Product("Oil", 23.0, 15000, scanner);
    Product milk = new Product("Milk", 7.25, 12000, scanner);
    Product water = new Product("Water", 0.75, 100000, scanner);
    Customer customer1 = new Customer("Ahmet", 156, scanner);
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Product> cart = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    products.add(bread);
    products.add(cheese);
    products.add(oil);
    products.add(milk);
    products.add(water);

    int choice;
    double total = 0;
    do {
      CLI();
      choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice){
        case 1:
          bread.showInfo();
          cheese.showInfo();
          milk.showInfo();
          oil.showInfo();
          water.showInfo();
          break;
        case 2:
          total = customer1.addToCart(cart,products);
          break;
        case 3:
          for (Product cart1 : cart) {
            System.out.println(cart1);
          }
          break;
        case 4:
          customer1.showCost(cart);
          break;
        case 5:
          customer1.balance = customer1.costPay(total);
          if (customer1.balance == -1) {
            System.out.println("Unsuccessful!! ");
          }
          else {
            System.out.println("Successfully paid! ");
            System.out.println("Remaining balance: " + customer1.balance);
            Order order1 = new Order(customer1, cart, total, LocalDate.now());
            orders.add(order1);
          }
          break;
         case 6:
          if (orders.isEmpty()) {
            System.out.println("No previous orders yet! ");
          }
          else {
            for (Order order : orders) {
              order.showOrderDetails();
              cart.clear();
              total = 0;
             }
          }
          break;
          case 7:
            System.out.println("You exit successfully! ");
            break;
          default:
            System.out.println("Invalid choice! ");
            break;
        }
    } while(choice != 7);


    scanner.close();
  }

  public static void CLI() {
    System.out.println("******************");
    System.out.println("1- Show Products ");
    System.out.println("2- Add to cart ");
    System.out.println("3- Show cart ");
    System.out.println("4- Show the payment ");
    System.out.println("5- Make the payment ");
    System.out.println("6- Show history ");
    System.out.println("7- Exit");
    System.out.println("******************");
  }
}