package day0729;

public class ScoreRankingPractice {
    public static void main(String[] args) {
        int[] scores = {85, 92, 58, 76, 92, 100, 45, 85, 60};

        selectionSortDescending(scores);

        System.out.println("Rank\tScore\tStatus");
        System.out.println("------------------------");

        int currentRank = 1;
        for (int i = 0; i < scores.length; i++) {
            if (i > 0 && scores[i] < scores[i - 1]) {
                currentRank = i + 1;
            }

            String status = scores[i] >= 60 ? "Pass" : "Fail";
            System.out.println(currentRank + "\t" + scores[i] + "\t" + status);
        }
    }

    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
}
