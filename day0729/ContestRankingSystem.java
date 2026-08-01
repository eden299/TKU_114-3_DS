package day0729;

public class ContestRankingSystem {
    public static void main(String[] args) {
        Contestant[] contestants = {
            new Contestant("C001", "Alice", 85, 120.5),
            new Contestant("C002", "Bob", 95, 110.0),
            new Contestant("C003", "Charlie", 85, 105.2),
            new Contestant("C004", "David", 95, 108.4),
            new Contestant("C005", "Eve", 70, 150.0),
            new Contestant("C006", "Frank", 85, 105.2)
        };

        insertionSortContestants(contestants);

        System.out.println("=== Contestant Leaderboard ===");
        System.out.println("Rank\tDetails");
        System.out.println("--------------------------------------------------");

        int currentRank = 1;
        for (int i = 0; i < contestants.length; i++) {
            if (i > 0) {
                boolean sameScore = contestants[i].getScore() == contestants[i - 1].getScore();
                boolean sameSeconds = contestants[i].getSeconds() == contestants[i - 1].getSeconds();
                if (!sameScore || !sameSeconds) {
                    currentRank = i + 1;
                }
            }
            System.out.println(currentRank + "\t" + contestants[i]);
        }
    }

    public static void insertionSortContestants(Contestant[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Contestant key = arr[i];
            int j = i - 1;

            while (j >= 0 && shouldSwap(arr[j], key)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static boolean shouldSwap(Contestant current, Contestant key) {
        if (current.getScore() < key.getScore()) {
            return true;
        } else if (current.getScore() == key.getScore()) {
            return current.getSeconds() > key.getSeconds();
        }
        return false;
    }
}
