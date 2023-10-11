import java.util.*;

class ECommerceSystem {
    private List<Product> products = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();
    public User loggedInUser;

    public void register(String username, String password) {
        users.put(username, new User(username, password));
        System.out.println("Registration successful. You can now log in.");
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful. Welcome, " + username + "!");
            return true;
        }
        System.out.println("Login failed. Please check your credentials.");
        return false;
    }

    public void listProducts(String category) {
        if (loggedInUser == null) {
            System.out.println("Please log in to see products.");
            return;
        }

        System.out.println("Products in the " + category + " category:");
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                System.out.println(product);
            }
        }
    }

    public void addProduct(int productId, String name, String category, int price) {
        products.add(new Product(productId, name, category, price));
    }

    public void buyProduct(int productId) {
        if (loggedInUser == null) {
            System.out.println("Please log in to buy products.");
            return;
        }

        Product product = products.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElse(null);

        if (product != null) {
            System.out.println("You are buying " + product.getName());
            System.out.println("The price of the product you want to purchase is $" + product.getPrice());
            System.out.print("Do you want to purchase (Yes/No): ");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Yes")) {
                System.out.println("Your purchase is successful. Thank you for shopping with us!");
            } else {
                System.out.println("Your transaction has been canceled.");
            }
        } else {
            System.out.println("Invalid product ID. Please check the product ID and try again.");
        }
    }
}
