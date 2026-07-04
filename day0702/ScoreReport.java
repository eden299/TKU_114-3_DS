package day0702;
import java.util.Scanner;
public class ScoreReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("請輸入姓名：");
        String name = sc.nextLine();

        System.out.println("請輸入 Java 成績：");
        int Java = sc.nextInt();

        System.out.println("請輸入 English 成績：");
        int English = sc.nextInt();

        System.out.println("請輸入 Math 成績：");
        int Math = sc.nextInt();

        double average = (Java + English + Math) / 3.0;

        System.out.println("姓名: " + name);
        System.out.println("Java: " + Java);
        System.out.println("English: " + English);
        System.out.println("Math: " + Math);
        System.out.println("平均: " + average);
    }
    
}
