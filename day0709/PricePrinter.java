package day0709;

public class PricePrinter {
    public static void main(String[] args) {
        printItem("Apple",30);
        printItem("Pen",20);
    }

    public static void printItem(String itemName ,int price) {
        System.out.println("Item name: " + itemName + ", Price:" + price);
    }
}
