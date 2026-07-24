package day0722;

public class PlaylistSystem {
    public static void main(String[] args) {
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        System.out.println("=== 1. 測試尾端新增歌曲 ===");
        playlist.addLast("S001", "Song A");
        playlist.addLast("S002", "Song B");
        playlist.addLast("S003", "Song C");
        playlist.addLast("S004", "Song D");
        playlist.printPlaylist();

        System.out.println("\n=== 2. 測試歌曲代碼重複防護 ===");
        playlist.addLast("S002", "Duplicate Song B"); 

        System.out.println("\n=== 3. 測試搜尋功能 ===");
        PlaylistNode found = playlist.search("S003");
        if (found != null) {
            System.out.println("搜尋成功: 找到 [" + found.id + "] " + found.title);
        } else {
            System.out.println("搜尋失敗：找不到該歌曲");
        }

        System.out.println("\n=== 4. 測試刪除第一首 (S001) ===");
        playlist.remove("S001");
        playlist.printPlaylist();

        System.out.println("\n=== 5. 測試刪除最後一首 (S004) ===");
        playlist.remove("S004");
        playlist.printPlaylist();

        System.out.println("\n=== 6. 測試刪除不存在的歌曲 (S099) ===");
        playlist.remove("S099");

        System.out.println("\n=== 7. 清空清單並測試空串列操作 ===");
        playlist.remove("S002");
        playlist.remove("S003");
        playlist.printPlaylist();
        playlist.remove("S001"); 
    }
}
