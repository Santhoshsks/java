class Product {
    private int productId;
    private String name;
    private String category;
    private int price;

    public Product(int productId, String name, String category, int price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (ID: " + productId + ", Price: Rs." + price + ")";
    }
}
