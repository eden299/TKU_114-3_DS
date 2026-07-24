package day0722;

public class TaskLinkedListSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("=== 1. 測試新增工作 (一般與緊急) ===");
        taskList.addNormalTask("T001", "撰寫 Java 作業");
        taskList.addNormalTask("T002", "整理 GitHub 儲存庫");
        taskList.addUrgentTask("T999", "修復緊急伺服器 Bug"); 
        taskList.addNormalTask("T003", "準備期末考試");

        taskList.printUnfinishedTasksAndStats();

        System.out.println("\n=== 2. 測試標記完成工作 ===");
        taskList.completeTask("T999"); 
        taskList.completeTask("T002");
        taskList.completeTask("T000");

        taskList.printUnfinishedTasksAndStats();

        System.out.println("\n=== 3. 測試刪除工作 ===");
        taskList.removeTask("T999"); 
        taskList.removeTask("T003"); 
        taskList.removeTask("T888"); 

        taskList.printUnfinishedTasksAndStats();
    }
}
