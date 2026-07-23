package day0721;

public class Equipment {
    private String id;     
    private String name;       
    private boolean isAvailable; 

    public Equipment(String id, String name) {
        this.id = id;
        this.name = name;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("代碼: %-8s | 名稱: %-15s | 狀態: %s", 
                id, name, (isAvailable ? "可借用" : "已借出"));
    }
}
