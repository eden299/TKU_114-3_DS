package day0729;

public class ProductSortingSystem {
    public static void main(String[] args) {
        StoreProduct[] originalData = {
            new StoreProduct("P001", "Laptop", 1200.0, 15),
            new StoreProduct("P002", "Mouse", 25.0, 100),
            new StoreProduct("P003", "Keyboard", 75.0, 45),
            new StoreProduct("P004", "Monitor 24\"", 200.0, 20),
            new StoreProduct("P005", "Monitor 27\"", 350.0, 10),
            new StoreProduct("P006", "Desk Lamp", 30.0, 60),
            new StoreProduct("P007", "USB Cable", 10.0, 200),
            new StoreProduct("P008", "Headphones", 150.0, 30),
            new StoreProduct("P009", "Webcam", 80.0, 25),
            new StoreProduct("P010", "Speaker", 120.0, 18)
        };

        System.out.println("=== Mode 1: Price Ascending ===");
        StoreProduct[] mode1Data = copyArray(originalData);
        sortByPriceAscending(mode1Data);
        printProducts(mode1Data);

        System.out.println("\n=== Mode 2: Price Descending ===");
        StoreProduct[] mode2Data = copyArray(originalData);
        sortByPriceDescending(mode2Data);
        printProducts(mode2Data);

        System.out.println("\n=== Mode 3: Stock Descending ===");
        StoreProduct[] mode3Data = copyArray(originalData);
        sortByStockDescending(mode3Data);
        printProducts(mode3Data);
    }

    public static StoreProduct[] copyArray(StoreProduct[] source) {
        StoreProduct[] copy = new StoreProduct[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i].copy();
        }
        return copy;
    }

    public static void sortByPriceAscending(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrice() > key.getPrice()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void sortByPriceDescending(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrice() < key.getPrice()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void sortByStockDescending(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getStock() < key.getStock()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printProducts(StoreProduct[] arr) {
        for (StoreProduct p : arr) {
            System.out.println(p);
        }
    }
}
