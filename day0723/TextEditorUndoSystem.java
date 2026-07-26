package day0723;

import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditorUndoSystem {
    private StringBuilder content = new StringBuilder();

    private Deque<String> history = new ArrayDeque<>();

    public void append(String str) {
        saveState();
        content.append(str);
        System.out.println("-> [新增文字] \"" + str + "\" | 當前內容: \"" + content + "\"");
    }

    public void delete(int count) {
        if (count <= 0) return;
        
        saveState();
        int len = content.length();
        if (count >= len) {
            content.setLength(0); 
        } else {
            content.delete(len - count, len);
        }
        System.out.println("-> [刪除 " + count + " 個字元] | 當前內容: \"" + content + "\"");
    }

    private void saveState() {
        history.push(content.toString());
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("[警告] 沒有歷史紀錄可以 Undo！");
            return;
        }

        content = new StringBuilder(history.pop());
        System.out.println("<- [執行 Undo] 還原後內容: \"" + content + "\"");
    }

    public void display() {
        System.out.println("[顯示內容] \"" + content.toString() + "\"");
    }

    public static void main(String[] args) {
        TextEditorUndoSystem editor = new TextEditorUndoSystem();

        System.out.println("=== 開始文字編輯 Undo 測試 ===");

        editor.undo();

        editor.append("Hello");
        editor.append(" World");
        editor.append("!");
        editor.delete(1);
        editor.append(" Java Programming");

        editor.display();

        System.out.println("\n--- 開始連續 Undo 三次測試 ---");
        editor.undo(); 
        editor.undo(); 
        editor.undo(); 

        System.out.println("\n--- 最終驗證 ---");
        editor.display();

        System.out.println("=== 測試完成 ===");
    }
}
