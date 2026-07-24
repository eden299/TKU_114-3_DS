package day0722;

public class PlaylistLinkedList {
    private PlaylistNode head;

    public PlaylistLinkedList() {
        this.head = null;
    }

    public PlaylistNode search(String id) {
        PlaylistNode curr = head;
        while (curr != null) {
            if (curr.id.equals(id)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public boolean addLast(String id, String title) {
        if (search(id) != null) {
            System.out.println("新增失敗：歌曲代碼 [" + id + "] 已存在！");
            return false;
        }

        PlaylistNode newNode = new PlaylistNode(id, title);
        if (head == null) {
            head = newNode;
        } else {
            PlaylistNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("成功新增歌曲: [" + id + "] " + title);
        return true;
    }

    public boolean remove(String id) {
        if (head == null) {
            System.out.println("刪除失敗：播放清單為空！");
            return false;
        }

        if (head.id.equals(id)) {
            System.out.println("成功刪除（第一首）：[" + head.id + "] " + head.title);
            head = head.next;
            return true;
        }

        PlaylistNode curr = head;
        while (curr.next != null && !curr.next.id.equals(id)) {
            curr = curr.next;
        }

        if (curr.next == null) {
            System.out.println("刪除失敗：找不到歌曲代碼 [" + id + "]");
            return false;
        }

        System.out.println("成功刪除：[" + curr.next.id + "] " + curr.next.title);
        curr.next = curr.next.next;
        return true;
    }

    public void printPlaylist() {
        System.out.println("\n--- 完整播放清單 ---");
        if (head == null) {
            System.out.println("(播放清單為空)");
            return;
        }
        PlaylistNode curr = head;
        int index = 1;
        while (curr != null) {
            System.out.println(index + ". [" + curr.id + "] " + curr.title);
            curr = curr.next;
            index++;
        }
    }
}
