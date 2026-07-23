package day0721;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("=== 課堂實作題一：動態成績管理 ===");
        System.out.println("請輸入成績 (0 ~ 100)，輸入 -1 結束輸入：");

        while (true) {
            System.out.print("請輸入成績: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input == -1) {
                    break;
                }
                if (input >= 0 && input <= 100) {
                    scores.add(input);
                } else {
                    System.out.println("【錯誤】無效成績！僅接受 0 到 100 之間的數值。");
                }
            } else {
                System.out.println("【錯誤】輸入格式錯誤，請輸入整數！");
                scanner.next();
            }
        }

        if (scores.isEmpty()) {
            System.out.println("\n未輸入任何有效成績。");
        } else {
            System.out.println("\n=== 統計結果 ===");
            System.out.println("總筆數: " + scores.size());
            System.out.printf("平均分數: %.2f\n", calculateAverage(scores));
            System.out.println("最高分: " + findMax(scores));
            System.out.println("最低分: " + findMin(scores));
            
            ArrayList<Integer> passingScores = getPassingScores(scores);
            System.out.println("及格名單 (" + passingScores.size() + " 筆): " + passingScores);
        }

        scanner.close();
    }

    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) return 0.0;
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    public static int findMax(ArrayList<Integer> scores) {
        int max = scores.get(0);
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static int findMin(ArrayList<Integer> scores) {
        int min = scores.get(0);
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public static ArrayList<Integer> getPassingScores(ArrayList<Integer> scores) {
        ArrayList<Integer> passing = new ArrayList<>();
        for (int score : scores) {
            if (score >= 60) {
                passing.add(score);
            }
        }
        return passing;
    }
}
