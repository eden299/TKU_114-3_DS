package day0723;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ClinicQueueSystem {
    private Queue<Patient> queue = new ArrayDeque<>();

    private Set<Integer> usedIds = new HashSet<>();

    private int totalServedCount = 0;

    public boolean register(int id, String name, String department) {
        if (usedIds.contains(id)) {
            System.out.println("[錯誤] 掛號失敗：號碼 " + id + " 已存在！");
            return false;
        }

        Patient patient = new Patient(id, name, department);
        queue.offer(patient);
        usedIds.add(id);
        System.out.println("-> [掛號成功] " + patient);
        return true;
    }

    public void callNext() {
        if (queue.isEmpty()) {
            System.out.println("[提示] 當前沒有等待叫號的病患。");
            return;
        }

        Patient current = queue.poll();
        totalServedCount++;
        System.out.println("<- [診所叫號] 請 " + current + " 至診室看診");
    }

    public void peekNext() {
        if (queue.isEmpty()) {
            System.out.println("[資訊] 目前無下一位等待病患。");
        } else {
            System.out.println("[資訊] 下一位病患：" + queue.peek());
        }
    }

    public void showWaitingList() {
        System.out.println("\n--- 當前等待清單 ---");
        if (queue.isEmpty()) {
            System.out.println("（無人等待）");
        } else {
            for (Patient p : queue) {
                System.out.println("  " + p);
            }
        }
        System.out.println("--------------------\n");
    }

    public void showStatistics() {
        Map<String, Integer> deptCountMap = new HashMap<>();

        for (Patient p : queue) {
            deptCountMap.put(p.getDepartment(), deptCountMap.getOrDefault(p.getDepartment(), 0) + 1);
        }

        System.out.println("================ 診所統計數據 ================");
        System.out.println("各科別等待人數：");
        if (deptCountMap.isEmpty()) {
            System.out.println("  （目前無等待病患）");
        } else {
            for (Map.Entry<String, Integer> entry : deptCountMap.entrySet()) {
                System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + " 人");
            }
        }
        System.out.println("已完成服務總人數：" + totalServedCount + " 人");
        System.out.println("=============================================\n");
    }

    public static void main(String[] args) {
        ClinicQueueSystem system = new ClinicQueueSystem();

        System.out.println("=== 開始診所叫號系統測試 ===");

        system.callNext();

        system.register(101, "張三", "內科");
        system.register(102, "李四", "外科");
        system.register(103, "王五", "內科");
        system.register(104, "趙六", "兒科");

        system.register(101, "陳七", "內科"); 

        system.showWaitingList();
        system.peekNext();

        system.callNext(); 
        system.callNext(); 

        system.showStatistics();

        system.register(105, "孫八", "兒科");
        system.callNext();

        system.showStatistics();

        System.out.println("=== 測試完成 ===");
    }
}
