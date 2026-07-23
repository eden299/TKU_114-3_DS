package day0721;

public class Course {
    private String id;
    private String name;
    private int capacity;
    private int enrolledCount;

    public Course(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.enrolledCount = 0; 
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    public boolean isFull() {
        return enrolledCount >= capacity;
    }

    public boolean enroll() {
        if (isFull()) {
            return false;
        }
        enrolledCount++;
        return true;
    }

    public boolean drop() {
        if (enrolledCount <= 0) {
            return false;
        }
        enrolledCount--;
        return true;
    }

    @Override
    public String toString() {
        return String.format("代碼: %-6s | 名稱: %-12s | 人數: %2d/%2d | 狀態: %s", 
                id, name, enrolledCount, capacity, (isFull() ? "【已額滿】" : "可加選"));
    }
}
