package day0730;

public class RepairTask {
    private String id;
    private String deviceName;
    private int priority;
    private int registrationOrder;

    public RepairTask(String id, String deviceName, int priority, int registrationOrder) {
        this.id = id;
        this.deviceName = deviceName;
        this.priority = priority;
        this.registrationOrder = registrationOrder;
    }

    public String getId() {
        return id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public int getPriority() {
        return priority;
    }

    public int getRegistrationOrder() {
        return registrationOrder;
    }

    @Override
    public String toString() {
        return "RepairTask[ID=" + id + ", Device='" + deviceName + "', Priority=" + priority + ", Order=" + registrationOrder + "]";
    }
}
