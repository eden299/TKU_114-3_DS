package day0715;

import java.util.Scanner;

public class DebuggingChallenge {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {80, 75, 92};
        int total = 0;

        // 修正 2: 將 <= 改為 < 防止陣列越界
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        // 修正 3: 強制轉型以保留小數點
        double average = (double) total / scores.length;
        System.out.printf("平均 : %.2f%n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();
        
        // 修正 4: 清除 sc.nextInt() 留在緩衝區的換行符號
        sc.nextLine(); 

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        // 修正 5: 改用 .equals() 比較字串內容
        if (command.equals("exit")) {
            // 修正 1: 補上結尾分號
            System.out.println("系統結束，年齡：" + age);
        }

        sc.close();
    }
}

