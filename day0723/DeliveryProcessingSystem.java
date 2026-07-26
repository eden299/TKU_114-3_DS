package day0723;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DeliveryProcessingSystem {
    private Queue<DeliveryTask> pendingQueue = new ArrayDeque<>();

    private Deque<DeliveryTask> completedStack = new ArrayDeque<>();

    public void addTask(String taskId, String address) {
        DeliveryTask task = new DeliveryTask(taskId, address);
        pendingQueue.offer(task);
        System.out.println("-> [新增工作] " + task);
    }

    public void completeNextTask() {
        if (pendingQueue.isEmpty()) {
            System.out.println("[警告] 目前無待配送工作可完成！");
            return;
        }

        DeliveryTask task = pendingQueue.poll();
        completedStack.push(task);
        System.out.println("<- [完成配送] " + task + " 已移至完成紀錄");
    }

    public void peekNextTask() {
        if (pendingQueue.isEmpty()) {
            System.out.println("[資訊] 當前無待配送工作。");
        } else {
            System.out.println("[資訊] 下一筆待配送工作：" + pendingQueue.peek());
        }
    }

    public void undoLastCompleted() {
        if (completedStack.isEmpty()) {
            System.out.println("[警告] 目前沒有已完成的紀錄可供復原！");
            return;
        }

        DeliveryTask restoredTask = completedStack.pop();
        pendingQueue.offer(restoredTask); 
        System.out.println("<-> [復原工作] " + restoredTask + " 已放回待配送佇列尾端");
    }

    public void showStatusAndHistory() {
        System.out.println("\n================ 配送工作系統狀態 ================");
        System.out.println("等待配送數量：" + pendingQueue.size() + " 筆");
        System.out.println("已完成數量  ：" + completedStack.size() + " 筆");

        System.out.println("\n--- [ Queue ] 待配送清單 (由頭至尾) ---");
        if (pendingQueue.isEmpty()) {
            System.out.println("  （無待配送工作）");
        } else {
            for (DeliveryTask task : pendingQueue) {
                System.out.println("  " + task);
            }
        }

        System.out.println("\n--- [ Stack ] 已完成紀錄 (由最新到最舊) ---");
        if (completedStack.isEmpty()) {
            System.out.println("  （無已完成紀錄）");
        } else {
            for (DeliveryTask task : completedStack) {
                System.out.println("  " + task);
            }
        }
        System.out.println("=================================================\n");
    }

    public static void main(String[] args) {
        DeliveryProcessingSystem system = new DeliveryProcessingSystem();

        System.out.println("=== 開始配送工作流程測試 ===");

        system.completeNextTask();
        system.undoLastCompleted();

        system.addTask("T101", "台北市信義區路一段1號");
        system.addTask("T102", "新北市板橋區縣民大道2號");
        system.addTask("T103", "桃園市中壢區中正路3號");

        system.peekNextTask();
        system.showStatusAndHistory();

        system.completeNextTask(); 
        system.completeNextTask(); 

        system.showStatusAndHistory();

        System.out.println("--- 測試復原最近完成工作 ---");
        system.undoLastCompleted();
        system.showStatusAndHistory();

        system.completeNextTask(); 
        system.completeNextTask(); 

        system.showStatusAndHistory();

        System.out.println("=== 測試完成 ===");
    }
}
