package day0729;

public class StoreProduct {
    private String id;
    private String name;
    private double price;
    private int stock;

    public StoreProduct(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public StoreProduct copy() {
        return new StoreProduct(this.id, this.name, this.price, this.stock);
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Name: %-12s | Price: %-8.2f | Stock: %-5d", id, name, price, stock);
    }
}
