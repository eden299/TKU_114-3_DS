package day0721;

public class CartItem {
    private String id;        // 商品代碼
    private String name;      // 商品名稱
    private double price;     // 單價
    private int quantity;     // 數量

    public CartItem(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // 計算該商品的小計金額
    public double getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("代碼: %-6s | 名稱: %-12s | 單價: %-8.1f | 數量: %-4d | 小計: %.1f", 
                id, name, price, quantity, getSubtotal());
    }
}
