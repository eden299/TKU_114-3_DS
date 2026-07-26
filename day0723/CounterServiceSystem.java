package day0723;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CounterServiceSystem {
    static class Customer {
        int number;
        String name;

        public Customer(int number, String name) {
            this.number = number;
            this.name = name;
        }

        @Override
        public String toString() {
            return "【" + number + "號 " + name + "】";
        }
    }

    private Queue<Customer> queue = new ArrayDeque<>();

    private List<Customer> historyLog = new ArrayList<>();

    private int nextNumber = 1;

    public void takeNumber(String name) {
        Customer customer = new Customer(nextNumber++, name);
        queue.offer(customer);
        System.out.println("-> [取號成功] " + customer + "，目前前面有 " + (queue.size() - 1) + " 人等待");
    }

    public void callNext() {
        if (queue.isEmpty()) {
            System.out.println("[提示] 目前沒有人在等待，無法叫號！");
            return;
        }

        Customer current = queue.poll();
        historyLog.add(current); 
        System.out.println("<- [櫃台叫號] 請 " + current + " 到櫃台辦理業務");
    }

    public void peekNext() {
        if (queue.isEmpty()) {
            System.out.println("[資訊] 當前無等待顧客。");
        } else {
            System.out.println("[資訊] 下一位等待的顧客是：" + queue.peek());
        }
    }

    public void showWaitingCount() {
        System.out.println("[統計] 當前等待人數：" + queue.size() + " 人");
    }

    public void showHistoryLog() {
        System.out.println("\n=== 已處理完畢的紀錄 ===");
        if (historyLog.isEmpty()) {
            System.out.println("（尚無服務紀錄）");
        } else {
            for (int i = 0; i < historyLog.size(); i++) {
                System.out.println((i + 1) + ". " + historyLog.get(i));
            }
        }
        System.out.println("========================\n");
    }

    public static void main(String[] args) {
        CounterServiceSystem system = new CounterServiceSystem();

        System.out.println("=== 開始櫃台叫號系統測試 ===");

        system.callNext();

        system.takeNumber("王小明");
        system.takeNumber("陳美麗");
        system.takeNumber("林大華");

        system.showWaitingCount();
        system.peekNext();

        system.callNext();
        system.callNext();

        system.takeNumber("張三");

        system.callNext();
        system.callNext();

        system.callNext();

        system.showHistoryLog();

        System.out.println("=== 測試完成 ===");
    }
}
