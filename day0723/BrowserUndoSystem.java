package day0723;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserUndoSystem {
    private Deque<String> history = new ArrayDeque<>();

    public void visit(String url) {
        history.push(url);
        System.out.println("-> 前往頁面：" + url);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("[警告] 目前沒有上一頁可以返回！");
            return;
        }
        
        String poppedPage = history.pop();
        System.out.println("<- 離開頁面：" + poppedPage);

        if (!history.isEmpty()) {
            System.out.println("   目前停留在：" + history.peek());
        } else {
            System.out.println("   目前頁面已清空。");
        }
    }

    public void currentPage() {
        if (history.isEmpty()) {
            System.out.println("[資訊] 當前沒有開啟任何頁面。");
        } else {
            System.out.println("[資訊] 當前頁面：" + history.peek());
        }
    }

    public static void main(String[] args) {
        BrowserUndoSystem browser = new BrowserUndoSystem();

        System.out.println("=== 開始瀏覽器操作測試 ===");
        
        browser.back(); 
        browser.currentPage();

        browser.visit("https://google.com");
        browser.visit("https://github.com");
        browser.visit("https://stackoverflow.com");

        browser.currentPage();

        browser.back();
        browser.back();

        browser.visit("https://youtube.com");
        browser.currentPage();

        System.out.println("=== 測試完成 ===");
    }
}
