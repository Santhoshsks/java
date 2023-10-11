import java.util.*;

public class ECommerce {
    public static void main(String[] args) {
        ECommerceSystem ecommerce = new ECommerceSystem();
        ecommerce.addProduct(1, "Laptop", "Electronics", 800);
        ecommerce.addProduct(2, "T-shirt", "Clothing", 20);

        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;

        while (true) {
            System.out.println("Welcome!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. List Products");
            System.out.println("4. Buy Products");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter a password: ");
                    String password = sc.nextLine();
                    ecommerce.register(username, password);
                    break;
                case 2:
                    if (!loggedIn) {
                        System.out.print("Enter your username: ");
                        String loginUsername = sc.nextLine();
                        System.out.print("Enter your password: ");
                        String loginPassword = sc.nextLine();
                        loggedIn = ecommerce.login(loginUsername, loginPassword);
                    } else {
                        System.out.println("You are already logged in as " + ecommerce.loggedInUser.getUsername());
                    }
                    break;
                case 3:
                    System.out.print("Enter the category of products you want to choose from (Electronics/Clothing): ");
                    String category = sc.nextLine();
                    ecommerce.listProducts(category);
                    break;
                case 4:
                    System.out.print("Enter the product ID you want to buy: ");
                    int productId = sc.nextInt();
                    ecommerce.buyProduct(productId);
                    break;
                case 5:
                    System.out.println("Thank you for using the E-Commerce System. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
